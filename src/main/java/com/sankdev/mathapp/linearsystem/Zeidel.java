package com.sankdev.mathapp.linearsystem;

public class Zeidel {


  double EPS = 0.001;

  public double[] findSolution(double[][] matrix) {
    return findSolution(matrix, EPS);
  }

  public double[] findSolution(double[][] matrix, double eps) {
    int size = matrix.length;
    double[] previousVariableValues = new double[size];
    for (int i = 0; i < size; i++) {
      previousVariableValues[i] = 0.0;
    }
    // Будем выполнять итерационный процесс до тех пор,
    // пока не будет достигнута необходимая точность
    while (true) {
      // Введем вектор значений неизвестных на текущем шаге
      double[] currentVariableValues = new double[size];

      // Посчитаем значения неизвестных на текущей итерации
      // в соответствии с теоретическими формулами
      for (int i = 0; i < size; i++) {
        // Инициализируем i-ую неизвестную значением
        // свободного члена i-ой строки матрицы
        currentVariableValues[i] = matrix[i][size];

        // Вычитаем сумму по всем отличным от i-ой неизвестным
        for (int j = 0; j < size; j++) {
          // При j < i можем использовать уже посчитанные
          // на этой итерации значения неизвестных
          if (j < i) {
            currentVariableValues[i] -= matrix[i][j] * currentVariableValues[j];
          }

          // При j > i используем значения с прошлой итерации
          if (j > i) {
            currentVariableValues[i] -= matrix[i][j] * previousVariableValues[j];
          }
        }

        // Делим на коэффициент при i-ой неизвестной
        currentVariableValues[i] /= matrix[i][i];
      }

      // Посчитаем текущую погрешность относительно предыдущей итерации
      double error = 0.0;

      for (int i = 0; i < size; i++) {
        error += Math.abs(currentVariableValues[i] - previousVariableValues[i]);
      }

      // Если необходимая точность достигнута, то завершаем процесс
      if (error < EPS) {
        break;
      }

      // Переходим к следующей итерации, так
      // что текущие значения неизвестных
      // становятся значениями на предыдущей итерации
      previousVariableValues = currentVariableValues;
    }

    return previousVariableValues;
  }

}
