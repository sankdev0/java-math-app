package com.sankdev.mathapp.integration;

public class TrapezoidalRule {

  /**********************************************************************
   * Standard normal distribution density function.
   * Replace with any sufficiently smooth function.
   **********************************************************************/
  static double f(double x) {
    return Math.cos(Math.pow(x, 3));
  }

  /**********************************************************************
   * Integrate f from a to b using the trapezoidal rule.
   * Increase N for more precision.
   **********************************************************************/
  static double integrate(double a, double b, int N) {
    double h = (b - a) / N;              // step size
    double sum = 0.5 * (f(a) + f(b));    // area
    for (int i = 1; i < N; i++) {
      double x = a + h * i;
      sum = sum + f(x);
    }

    return sum * h;
  }


  // sample client program
  public static void main(String[] args) {
    double a = 1;
    double b = 4;
    System.out.println(integrate(a, b, 8));
  }

}


