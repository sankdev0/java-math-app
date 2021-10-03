package com.sankdev.mathapp.linearsystem;

import java.util.Arrays;

class LinearSystemInteractor {

  private final double[][] A = {{0.9 , 2.7, -3.8}, {2.5, 5.8, -0.5}, {4.5, -2.1, 3.2}};
  private final double[] b = {2.4, 3.5, -1.2};
  private final double EPSILON = 0.001; // точность

  LinearSystemModel viewModel;

  public LinearSystemInteractor(LinearSystemModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  // Расчет результата методом Гаусса.
  public void gaussMethod() {

    double[] result = GaussianElimination.solve(A, b, EPSILON);
    String resultString = "Корни СЛАУ: " + Arrays.toString(result);
    viewModel.setLinearSystemResult(resultString);
  }

}
