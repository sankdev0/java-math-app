package com.sankdev.mathapp.linearsystem;

import java.util.Arrays;

public class Iterative {

  public static final int MAX_ITERATIONS = 50;

  private static boolean transformToDominant(double[][] M, int r, boolean[] V, int[] R)
  {
    int n = M.length;
    if (r == M.length) {
      double[][] T = new double[n][n+1];
      for (int i = 0; i < R.length; i++) {
        for (int j = 0; j < n + 1; j++)
          T[i][j] = M[R[i]][j];
      }

      M = T;

      return true;
    }

    for (int i = 0; i < n; i++) {
      if (V[i]) continue;

      double sum = 0;

      for (int j = 0; j < n; j++)
        sum += Math.abs(M[i][j]);

      if (2 * Math.abs(M[i][r]) > sum) { // diagonally dominant?
        V[i] = true;
        R[r] = i;

        if (transformToDominant(M,r + 1, V, R))
          return true;

        V[i] = false;
      }
    }

    return false;
  }


  /**
   * Returns true if is possible to transform M(data member) to a diagonally
   * dominant matrix, false otherwise.
   */
  private static boolean makeDominant(double[][] M)
  {
    boolean[] visited = new boolean[M.length];
    int[] rows = new int[M.length];

    Arrays.fill(visited, false);

    return transformToDominant(M, 0, visited, rows);
  }


  /**
   * Applies Jacobi method to find the solution of the system
   * of linear equations represented in matrix M.
   * M is a matrix with the following form:
   * a_11 * x_1 + a_12 * x_2 + ... + a_1n * x_n = b_1
   * a_21 * x_1 + a_22 * x_2 + ... + a_2n * x_n = b_2
   * .                 .                  .        .
   * .                 .                  .        .
   * .                 .                  .        .
   * a_n1 * x_n + a_n2 * x_2 + ... + a_nn * x_n = b_n
   */
  public static double[] solve(double[][] M, double[] b, double epsilon)
  {
    if(!makeDominant(M)) {
      System.out.println("Метод не гарантирует сходимость этой СЛАУ");
    }

    int iterations = 0;
    int n = M.length;
    double[] X = new double[n]; // Approximations
    double[] P = new double[n]; // Prev
    Arrays.fill(X, 0);
    Arrays.fill(P, 0);

    while (true) {
      for (int i = 0; i < n; i++) {
        double sum = M[i][n]; // b_n

        for (int j = 0; j < n; j++)
          if (j != i)
            sum -= M[i][j] * P[j];

        // Update x_i but it's no used in the next row calculation
        // but up to de next iteration of the method
        X[i] = 1/M[i][i] * sum;
      }

      System.out.print("X_" + iterations + " = {");
      for (int i = 0; i < n; i++)
        System.out.print(X[i] + " ");
      System.out.println("}");

      iterations++;
      if (iterations == 1) continue;

      boolean stop = true;
      for (int i = 0; i < n && stop; i++)
        if (Math.abs(X[i] - P[i]) > epsilon)
          stop = false;

      if (stop || iterations == MAX_ITERATIONS) break;
      P = (double[])X.clone();
    }

    return X;
  }

  // Решение простым итеративным методом (методом Якоби).
  public static double[] solveOld(double[][] A, double[] b, double epsilon) {

    int m = A.length; // количество строк
    int n = A[0].length; // количество столбцов
    double sum;

    // Выберем первое и следующее приближения.
    double[] x = new double[m];
    double[] xn = new double[m];
    boolean loop;

    //checking for row dominance
    loop = false;
    for (int i = 0; i < m; i++) {
      sum = 0;
      for (int j = 0; j < n; j++) {
        if (i != j) {
          sum += Math.abs(A[i][j]);
        }
      }
      if (sum > Math.abs(A[i][i])) {
        loop = true;
      }
    }

    //checking for column dominance
    if (loop) {
      loop = false;
    }
    for (int j = 1; j < n; j++) {
      sum = 0;
      for (int i = 1; i < m; i++) {
        if (i != j) {
          sum += Math.abs(A[i][j]);
        }
      }
      if (sum > Math.abs(A[j][j])) {
        loop = true;
      }
    }

    if (loop) {
      System.out.println("The coefficient matrix is not diagonally dominant \n");
      System.out.println("The Gauss-Jacobi method does not converge surely");
      return null;
    }

    do {
      for (int i = 0; i < m; i++) {
        sum = b[i];
        for (int j = 0; j < n; j++) {
          if (j != i) {
            sum -= A[i][j] * x[j];
          }
        }
        xn[i] = sum / A[i][i];
      }
      for (int i = 0; i < m; i++) {
        System.out.print(xn[i] + "; ");
        System.out.println();
      }
      loop = false;
      //indicates |x[i]-xn[i]|<epp for all i
      for (int i = 0; i < m; i++) {
        if (Math.abs(x[i] - xn[i]) > epsilon) {
          loop = true;
        }
      }
      if (loop) {
        for (int i = 1; i < m; i++) {
          x[i] = xn[i]; //reset x[i]
        }
      }

    } while (loop);

    return xn;
  }

}
