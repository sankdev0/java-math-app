package com.sankdev.mathapp;

class NonLinearEquationInteractor {

  NonLinearEquationModel viewModel;

  public NonLinearEquationInteractor(NonLinearEquationModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  private double a = -1; // начало интервала a
  private double b = 8; // конец интервала b
  private final double eps = 0.001; // точность

  // Расчет значения функции для аргумента x.
  public double functionValue(double x) {
    return Math.pow(x, 4) + 5 * x - 3;
  }

  // расчет середины отрезка
  public double segmentMidpoint(double a, double b) {
    return (a + b) / 2;
  }

  // Первая производная от функции
  public double f1(double x) {
    return 4 * Math.pow(x, 3) + 5;
  }

  // Реализация метода половинного деления.
  public void halfDivisionMethod() {
    double a = this.a;
    double b = this.b;
    while (Math.abs(b - a) > eps) {
      if (functionValue(a) * functionValue(segmentMidpoint(a, b)) < 0) {
        b = segmentMidpoint(a, b);
      } else {
        a = segmentMidpoint(a, b);
      }
    }
    viewModel.setNonLinearEquationResult(String.valueOf(segmentMidpoint(a, b)));
  }

  // Реализация метода хорд.
  public void chordMethod() {
    double a = this.a;
    double b = this.b;
    double xNext = 0;
    double temp;
    do {
      temp = xNext;
      xNext = b - functionValue(b) * (a - b) / (functionValue(a) - functionValue(b));
      a = b;
      b = temp;
    }
    while (Math.abs(xNext - b) > eps);
    viewModel.setNonLinearEquationResult(String.valueOf(xNext));
  }

  // Реализация метода касательных.
  public void tangentMethod() {
    double a = this.a;
    double b = this.b;
    double x = a;
    do {
      a = x;
      x = a - functionValue(x) / f1(x);
    }
    while (Math.abs(a - x) > eps);
    viewModel.setNonLinearEquationResult(String.valueOf(x));
  }

}
