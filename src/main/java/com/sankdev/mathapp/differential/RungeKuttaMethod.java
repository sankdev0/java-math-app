package com.sankdev.mathapp.differential;

public class RungeKuttaMethod {

  // Производная dy/dx в точке x и y.
  public static double derivative(double x, double y) {
    return x * y / 4;
  }


  // The `main' method does the actual computations
  public static double calcRungeKutta() {
    // Границы отрезка [0,2].
    double a = 0;
    double b = 2;
    // h - размер шага.
    double h = 0.2;
    double steps = (b - a) / h;
    double k1, k2, k3, k4;
    double x, y;

    // Расчет методом Рунге-Кутты 4-го порядка.
    // Инициализация y.
    y = 1;

    for (int i = 0; i < steps; i++) {
      // Шагаем.
      x = i * h;

      // Расчет четырех стадий
      k1 = h * derivative(x, y);
      k2 = h * derivative(x + h / 2, y + k1 / 2);
      k3 = h * derivative(x + h / 2, y + k2 / 2);
      k4 = h * derivative(x + h, y + k3);

      // Вычисляем приближенное значение в последующих точках y(n+1).
      y += k1 / 6 + k2 / 3 + k3 / 3 + k4 / 6;
    }

    return y;
  }
}
