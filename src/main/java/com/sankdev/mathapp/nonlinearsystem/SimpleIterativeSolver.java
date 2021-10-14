package com.sankdev.mathapp.nonlinearsystem;

// Идея метода простых итераций - представить систему уравнений в виде равносильной системы, выразив
// каждую из переменных в виде функции от остальных.
public class SimpleIterativeSolver {

  // 1. Задать начальное приближение, точность, положить k = 0.
  public static final double x0 = 0.54;
  public static final double y0 = -0.14;
  public static final double EPSILON = 0.001;

  // 2. Преобразовать СНУ
  public static double firstEquation(double y) {
    return 0 - Math.cos(y - 2);
  }

  public static double secondEquation(double x) {
    return Math.sin(x + 0.5) - 1;
  }

  // Вспомогательный метод.
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
    prevX[0] = x0;
    prevX[1] = y0;

    do {
      prevX[0] = currX[0];
      prevX[1] = currX[1];
      currX[0] = firstEquation(prevX[1]);
      currX[1] = secondEquation(prevX[0]);
    } while (!isAccurateEnough(currX, prevX, EPSILON));

    return currX;
  }
}
