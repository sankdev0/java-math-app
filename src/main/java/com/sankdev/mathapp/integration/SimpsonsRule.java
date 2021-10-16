package com.sankdev.mathapp.integration;


public class SimpsonsRule {

  public static double f(double x) {
    return 1 / (x + 3);
  }

  /*
  Интегрируй от a до b по правилу Симпсона.
   */
  public static double integrate(double a, double b, int N) {
    double h = (b - a) / (N - 1);     // размер шага

    // 1/3 слагаемые
    double sum = 1.0 / 3.0 * (f(a) + f(b));

    // 4/3 слагаемые
    for (int i = 1; i < N - 1; i += 2) {
      double x = a + h * i;
      sum += 4.0 / 3.0 * f(x);
    }

    // 2/3 слагаемые
    for (int i = 2; i < N - 1; i += 2) {
      double x = a + h * i;
      sum += 2.0 / 3.0 * f(x);
    }

    return sum * h;
  }


  // Демо-клиент.
  public static void main(String[] args) {
    double a = 1;
    double b = 2;
    System.out.println(integrate(a, b, 8));
  }

}


