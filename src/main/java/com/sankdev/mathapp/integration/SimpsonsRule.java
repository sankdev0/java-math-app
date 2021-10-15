package com.sankdev.mathapp.integration;


public class SimpsonsRule {

  /**********************************************************************
   * Standard normal distribution density function.
   * Replace with any sufficiently smooth function.
   **********************************************************************/
  public static double f(double x) {
    return 1 / (x + 3);
  }

  /**********************************************************************
   * Integrate f from a to b using Simpson's rule.
   * Increase N for more precision.
   **********************************************************************/
  public static double integrate(double a, double b) {
    int N = 8;                    // precision parameter
    double h = (b - a) / (N - 1);     // step size

    // 1/3 terms
    double sum = 1.0 / 3.0 * (f(a) + f(b));

    // 4/3 terms
    for (int i = 1; i < N - 1; i += 2) {
      double x = a + h * i;
      sum += 4.0 / 3.0 * f(x);
    }

    // 2/3 terms
    for (int i = 2; i < N - 1; i += 2) {
      double x = a + h * i;
      sum += 2.0 / 3.0 * f(x);
    }

    return sum * h;
  }


  // sample client program
  public static void main(String[] args) {
    double a = 1;
    double b = 2;
    System.out.println(integrate(a, b));
  }

}


