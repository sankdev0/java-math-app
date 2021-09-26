package com.sankdev.mathapp;

public class CheckSolution {

  public static double x = 0.5999999968081147;

  // Расчет значения функции для аргумента x.
  public static double functionValue(double x) {
    return Math.pow(x, 4) + 5 * x - 3;
  }

  public static void main(String[] args) {
    System.out.println("Check result: " + functionValue(x));
  }
}
