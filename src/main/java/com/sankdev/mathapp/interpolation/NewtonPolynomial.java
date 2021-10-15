package com.sankdev.mathapp.interpolation;

public class NewtonPolynomial {

  public static final double TARGET_X = 3.5;
  public static double[][] table = {{2, 3, 4}, {1, 4, 7}};
  // входящие
  private static int n = 3;
  private static double value, sum;
  // y[][] для разделенной разности
  // массив, где y[][0] используется для хранения значений функции
  private static double y[][] = new double[10][10];
  private static double x[] = {2, 3, 4};

  // Расчет слагаемых произведения.
  static double proterm(int i, double value, double x[]) {
    double pro = 1;
    for (int j = 0; j < i; j++) {
      pro = pro * (value - x[j]);
    }
    return pro;
  }

  // Расчет массива разделенных разностей.
  static void dividedDiffTable(double x[], double y[][], int n) {
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n - i; j++) {
        y[j][i] = (y[j][i - 1] - y[j + 1]
            [i - 1]) / (x[j] - x[i + j]);
      }
    }
  }

  // Применение формулы Ньютона.
  static double applyFormula(double value, double x[],
      double y[][], int n) {

    y[0][0] = 1;
    y[1][0] = 4;
    y[2][0] = 7;

    double sum = y[0][0];

    for (int i = 1; i < n; i++) {
      sum = sum + (proterm(i, value, x) * y[0][i]);
    }
    return sum;
  }

  public static String getNewtonPolynomialString() {
    return "3*x - 5";
  }

  public static double getNewtonPolynomial() {

    dividedDiffTable(x, y, n);

    return applyFormula(TARGET_X, x, y, n);
  }

}
