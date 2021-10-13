package com.sankdev.mathapp.nonlinearsystem;

import java.util.Arrays;

class NonLinearSystemInteractor {

  NonLinearSystemModel viewModel;

  public NonLinearSystemInteractor(NonLinearSystemModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  // Расчет результата методом простых итераций.
  public void simpleIterativeMethod() {

    double[] result = SimpleIterativeSolver.solveNonLinearSystem();
    String resultString = "Корни СЛАУ: " + Arrays.toString(result);
    viewModel.setNonLinearSystemResult(resultString);
  }

}
