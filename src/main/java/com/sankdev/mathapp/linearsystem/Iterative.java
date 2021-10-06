package com.sankdev.mathapp.linearsystem;

import java.util.Arrays;

public class Iterative {

  // Максимальное число итераций, которые выполнит метод.
  public static final int MAX_ITERATIONS = 20;


  // Рекурсивный метод для приведение матрицы к диагональному преобладанию.
  private static boolean transformToDominant(double[][] A, int row, boolean[] visited,
      int[] rows) {

    int n = A.length;

    if (row == A.length) {
      double[][] T = new double[n][n + 1];
      for (int i = 0; i < rows.length; i++) {
        for (int j = 0; j < n + 1; j++) {
          T[i][j] = A[rows[i]][j];
        }
      }

      A = T;

      return true;
    }

    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }

      double sum = 0;

      for (int j = 0; j < n; j++) {
        sum += Math.abs(A[i][j]);
      }

      if (2 * Math.abs(A[i][row]) > sum) { // есть ли диагональное преобладание?
        visited[i] = true;
        rows[row] = i;

        if (transformToDominant(A, row + 1, visited, rows)) {
          return true;
        }

        visited[i] = false;
      }
    }

    return false;
  }


  /**
   * Возвращает true, если можно преобразовать матрицу matrix в состояние диагонального
   * преобладания, false в противном случае.
   */
  private static boolean makeDominant(double[][] matrix) {

    boolean[] visited = new boolean[matrix.length];
    int[] rows = new int[matrix.length];

    Arrays.fill(visited, false);

    return transformToDominant(matrix, 0, visited, rows);
  }


  /**
   * Решение СЛАУ методом простых итераций (методом Якоби).
   */
  public static double[] solve(double[][] A, double[] b, double epsilon) {

    System.out.println("Метод простых итераций");

    int iterations = 0;
    int rows = A.length;
    int columns = A[0].length;

    // Создай полную матрицу системы, включая столбец b.
    double[][] fullA = new double[rows][columns + 1];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns + 1; j++) {
        if (j < columns) {
          fullA[i][j] = A[i][j];
        }
        if (j == columns) {
          fullA[i][j] = b[i];
        }
      }
    }

    System.out.println("Исходная матрица");
    for (int i = 0; i < fullA.length; i++) {
      for (int j = 0; j < fullA[0].length; j++) {
        System.out.print(fullA[i][j] + " ");
      }
      System.out.println();
    }

    if (!makeDominant(fullA)) {
      System.out.println("Метод не гарантирует сходимость этой СЛАУ");
    }

    System.out.println("Трансформированная матрица");
    for (int i = 0; i < fullA.length; i++) {
      for (int j = 0; j < fullA[0].length; j++) {
        System.out.print(fullA[i][j] + " ");
      }
      System.out.println();
    }

    double[] currX = new double[rows]; // текущее приближение
    double[] prevX = new double[rows]; // предыдущее приближение
    Arrays.fill(currX, 0);
    Arrays.fill(prevX, 0);

    while (true) {
      for (int i = 0; i < rows; i++) {
        double sum = fullA[i][rows];

        for (int j = 0; j < rows; j++) {
          if (j != i) {
            sum -= fullA[i][j] * prevX[j];
          }
        }

        // Обновить текущие значения Х для использования на следующей итерации.
        currX[i] = 1 / fullA[i][i] * sum;
      }

      System.out.print("X_" + iterations + " = {");
      for (int i = 0; i < rows; i++) {
        System.out.print(currX[i] + " ");
      }
      System.out.println("}");

      iterations++;
      if (iterations == 1) {
        continue;
      }

      boolean stop = true;
      for (int i = 0; i < rows && stop; i++) {
        if (Math.abs(currX[i] - prevX[i]) > epsilon) {
          stop = false;
        }
      }

      if (stop || iterations >= MAX_ITERATIONS) {
        break;
      }
      prevX = (double[]) currX.clone();
    }

    return currX;
  }

}
