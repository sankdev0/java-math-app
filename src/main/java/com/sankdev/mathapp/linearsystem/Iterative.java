package com.sankdev.mathapp.linearsystem;

public class Iterative {

  // Решение простым итеративным методом (методом Якоби).
  public static double[] solve(double[][] A, double[] b, double epsilon) {

    int m = A.length;
    int n = A[0].length;
    double sum;

    // Выберем первое и следующее приближения.
    double[] x = new double[m];
    double[] xn = new double[m];
    boolean flag;

    //checking for row dominance
    flag = false;
    for (int i = 0; i < m; i++) {
      sum = 0;
      for (int j = 0; j < n; j++) {
        if (i != j) {
          sum += Math.abs(A[i][j]);
        }
      }
      if (sum > Math.abs(A[i][i])) {
        flag = true;
      }
    }

    //checking for column dominance
    if (flag) {
      flag = false;
    }
    for (int j = 1; j < n; j++) {
      sum = 0;
      for (int i = 1; i < n; i++) {
        if (i != j) {
          sum += Math.abs(A[i][j]);
        }
      }
      if (sum > Math.abs(A[j][j])) {
        flag = true;
      }
    }

    if (flag) {
      System.out.println("The coefficient matrix is not diagonally dominant \n");
      System.out.println("The Gauss-Jacobi method does not converge surely");
      return null;
    }

    do {
      for (int i = 0; i < n; i++) {
        sum = b[i];
        for (int j = 0; j < n; j++) {
          if (j != i) {
            sum -= A[i][j] * x[j];
          }
        }
        xn[i] = sum / A[i][i];
      }
      for (int i = 0; i < n; i++) {
        System.out.printf("%8.5f ", xn[i]);
      }
      System.out.printf("\n");
      flag = false;
      //indicates |x[i]-xn[i]|<epp for all i
      for (int i = 0; i < n; i++) {
        if (Math.abs(x[i] - xn[i]) < epsilon) {
          flag = true;
        }
      }
      if (flag) {
        for (int i = 1; i < n; i++) {
          x[i] = xn[i]; //reset x[i]
        }
      }

    } while (flag);

    return xn;
  }

}
