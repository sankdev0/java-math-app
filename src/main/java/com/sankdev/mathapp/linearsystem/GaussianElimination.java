package com.sankdev.mathapp.linearsystem;

public class GaussianElimination {

  // Решение методом Гаусса с частичным перемещением (partial pivoting)
  public static double[] solve(double[][] A, double[] b, double epsilon) {
    int n = b.length;

    for (int p = 0; p < n; p++) {

      // Поиск строки для перемещения и перемещение
      int max = p;
      for (int i = p + 1; i < n; i++) {
        if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
          max = i;
        }
      }
      double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
      double   t    = b[p]; b[p] = b[max]; b[max] = t;

      // вырожденная или почти вырожденная
      if (Math.abs(A[p][p]) <= epsilon) {
        throw new ArithmeticException("Матрица вырожденная или почти вырожденная");
      }

      // сделай преобразование строк для A и b
      for (int i = p + 1; i < n; i++) {
        double alpha = A[i][p] / A[p][p];
        b[i] -= alpha * b[p];
        for (int j = p; j < n; j++) {
          A[i][j] -= alpha * A[p][j];
        }
      }
    }

    // обратный ход
    double[] x = new double[n];
    for (int i = n - 1; i >= 0; i--) {
      double sum = 0.0;
      for (int j = i + 1; j < n; j++) {
        sum += A[i][j] * x[j];
      }
      x[i] = (b[i] - sum) / A[i][i];
    }
    return x;
  }


  // тестовый прогон
  public static void main(String[] args) {
    int n = 3;
    double[][] A = {
        { 0, 1,  1 },
        { 2, 4, -2 },
        { 0, 3, 15 }
    };
    double[] b = { 4, 2, 36 };
    double[] x = solve(A, b, 0.001);


    // print results
    for (int i = 0; i < n; i++) {
      System.out.println(x[i]);
    }

  }

}
