package com.sankdev.mathapp.interpolation;

public class LagrangePolynomial {

  public static final double TARGET_X = 3.5;
  public static double[][] table = {{2, 3, 4}, {1, 4, 7}};

  public static String getLagrangePolynomialString() {
    return "3*x - 5";
  }

  public static double getLagrangePolynomial(double[][] table, double targetX) {

    double result = 0.0;
    double term = 0.0;
    for (int i = 0; i < table[1].length; i++) {
      term = table[1][i];
      for (int j = 0; j < table[1].length; j++) {
        if (j != i) {
          term = term * (targetX - table[0][j]) / (table[0][i] - table[0][j]);
        }
      }
      result = result + term;
    }
    return result;
  }

}