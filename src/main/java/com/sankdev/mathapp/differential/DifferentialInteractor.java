package com.sankdev.mathapp.differential;

class DifferentialInteractor {

  DifferentialModel viewModel;

  public DifferentialInteractor(DifferentialModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  // Решение ОДУ методом Рунге-Кутты 4-го порядка.
  public void RungeKutta() {

    double result = RungeKuttaMethod.calcRungeKutta();
    String resultString =
        "y = " + result;
    viewModel.setDifferentailResult(resultString);
  }

}
