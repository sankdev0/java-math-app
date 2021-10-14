package com.sankdev.mathapp.nonlinearsystem;

import com.sankdev.mathapp.linearsystem.GaussianEliminationSolver;

// Идея метода Ньютона - на каждой итерации решать систему W(Xk)*deltaX = - F(Xk) относительно
// поправки deltaXk, где W - матрица Якоби.
public class NewtonSolver {

  // 1. Задать начальное приближение, точность, положить k = 0.
  public static final double x0 = 0.54;
  public static final double y0 = -0.14;
  public static final double EPSILON = 0.001;

  // Исходные уравнения.
  public static double firstEquation(double x, double y) {
    return Math.sin(x + 0.5) - y - 1;
  }

  public static double secondEquation(double x, double y) {
    return x + Math.cos(y - 2);
  }

  // 2. Подготовить частные производные для матрицы Якоби.
  public static double dF1x(double x, double y) {
    return Math.cos(x + 0.5) - y;
  }

  public static double dF1y(double x, double y) {
    return Math.sin(x + 0.5) - 1;
  }

  public static double dF2x(double x, double y) {
    return 1 + Math.cos(y - 2);
  }

  public static double dF2y(double x, double y) {
    return x - Math.sin(y - 2);
  }

  // Вспомогательные методы.
  // Вычислить матрицу Якоби W(xk) для вектора Х размером 2.
  public static double[][] calcJacobiMatrix(double[] X, int size) {
    if (size != 2) {
      return null; // чтобы потом вылезла ошибка
    }
    int n = size;
    int m = size;
    double[][] W = new double[][]{{0.0, 0.0}, {0.0, 0.0}};

    W[0][0] = dF1x(X[0], X[1]);
    W[0][1] = dF1y(X[0], X[1]);
    W[1][0] = dF2x(X[0], X[1]);
    W[1][1] = dF2y(X[0], X[1]);

    return W;
  }

  // Вычислить вектор значений -F(xk).
  public static double[] calcNegativeFunctionResult(double x, double y) {

    double[] negF = new double[]{0.0, 0.0};
    negF[0] = (-1) * firstEquation(x, y);
    negF[1] = (-1) * secondEquation(x, y);

    return negF;
  }

  // Проверь, что достигнута заданная точность.
  public static boolean isAccurateEnough(double[] currX, double[] prevX, double epsilon) {

    double[] deltas = new double[currX.length];

    for (int i = 0; i < currX.length; i++) {
      deltas[i] = currX[i] - prevX[i];
    }

    double accuracy = deltas[0];
    for (int i = 1; i < deltas.length; i++) {
      if (deltas[i] > accuracy) {
        accuracy = deltas[i];
      }
    }

    accuracy = Math.abs(accuracy);

    return accuracy <= epsilon;
  }

  // 3. Рассчитать приближения и остановиться, когда достигнута нужная точность.
  public static double[] solveNonLinearSystem() {
    double[] prevX = new double[]{0.0, 0.0};
    double[] currX = new double[]{0.0, 0.0};
    currX[0] = x0;
    currX[1] = y0;

    do {
      prevX[0] = currX[0];
      prevX[1] = currX[1];
      // строим матрицу Якоби
      double[][] W = calcJacobiMatrix(currX, 2);
      // Вычислить значение -F(xk)
      double[] F = calcNegativeFunctionResult(currX[0], currX[1]);
      // Решить систему W(Xk)*deltaX = - F(Xk) методом Гаусса. Найти deltaXk.
      double[] deltaX = GaussianEliminationSolver.solve(W, F, EPSILON);
      // Вычислить следующее приближение.
      currX[0] = currX[0] + deltaX[0];
      currX[1] = currX[1] + deltaX[1];
    } while (!isAccurateEnough(currX, prevX, EPSILON));

    return currX;
  }
}
