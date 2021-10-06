package com.sankdev.mathapp.linearsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SeidelSolver {

  public static final int MAX_ITERATIONS = 100;
  private double[][] M;

  public SeidelSolver(double[][] A, double[] b) {
    int rows = A.length;
    int columns = A[0].length;
    // Создай полную матрицу системы, включая столбец b.
    M = new double[rows][columns + 1];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns + 1; j++) {
        if (j < columns) {
          M[i][j] = A[i][j];
        }
        if (j == columns) {
          M[i][j] = b[i];
        }
      }
    }
  }

  public SeidelSolver(double[][] A) {
    this.M = A;
  }

  public void print() // printing
  {
    int n = M.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n + 1; j++) {
        System.out.print(M[i][j] + " ");
      }
      System.out.println();
    }
  }

  // attempting to change a matrix to dominant
  // if proved that it is not
  public boolean transformToDominant(int r, boolean[] V,
      int[] R) {
    int n = M.length;
    if (r == M.length) {
      double[][] T = new double[n][n + 1];
      for (int i = 0; i < R.length; i++) {
        for (int j = 0; j < n + 1; j++) {
          T[i][j] = M[R[i]][j];
        }
      }
      M = T;
      return true;
    }
    for (int i = 0; i < n; i++) {
      if (V[i]) {
        continue;
      }
      double sum = 0;
      for (int j = 0; j < n; j++) {
        sum += Math.abs(M[i][j]);
      }
      if (2 * Math.abs(M[i][r]) > sum) {
        // диагонально доминирующая?
        V[i] = true;
        R[r] = i;
        if (transformToDominant(r + 1, V, R)) {
          return true;
        }
        V[i] = false;
      }
    }
    return false;
  }

  public boolean makeDominant() {
    boolean[] visited = new boolean[M.length];
    int[] rows = new int[M.length];
    Arrays.fill(visited, false);
    return transformToDominant(0, visited, rows);
  }

  public double[] solve() {
    int iterations = 0;
    int n = M.length;
    double epsilon = 0.001;
    double[] currX = new double[n];
    double[] prevX = new double[n];
    Arrays.fill(currX, 0);
    while (true) {
      for (int i = 0; i < n; i++) {
        double sum = M[i][n];
        for (int j = 0; j < n; j++) {
          if (j != i) {
            sum -= M[i][j] * currX[j];
          }
        }

        currX[i] = 1 / M[i][i] * sum;
      }
      System.out.print("X" + iterations + " = {");
      for (int i = 0; i < n; i++) {
        System.out.print(currX[i] + " ");
      }
      System.out.println("}");
      iterations++;
      if (iterations == 1) {
        continue;
      }
      boolean stop = true;
      for (int i = 0; i < n && stop; i++) {
        if (Math.abs(currX[i] - prevX[i]) > epsilon) {
          stop = false;
        }
      }
      if (stop || iterations == MAX_ITERATIONS) {
        break;
      }
      prevX = (double[]) currX.clone();
    }
    return currX;
  }

  public static void main(String[] args)
      throws IOException {
    PrintWriter writer
        = new PrintWriter(System.out, true);
    int n = 2, k = 1;
    double[][] M = new double[n][n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n + 1; j++) {
        M[i][j] = k++;
      }
    }
    SeidelSolver gausSeidel = new SeidelSolver(M);
    if (!gausSeidel.makeDominant()) {

      writer.println(
          "Система не является диагонально доминантной: "
              + "Метод не может гарантировать сходимость.");
    }
    writer.println();
    gausSeidel.print();
    gausSeidel.solve();
  }
}
