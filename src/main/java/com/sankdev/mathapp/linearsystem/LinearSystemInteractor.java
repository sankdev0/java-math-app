package com.sankdev.mathapp.linearsystem;

import java.util.Arrays;

class LinearSystemInteractor {

  private final double[][] A = {{0.9, 2.7, -3.8}, {2.5, 5.8, -0.5}, {4.5, -2.1, 3.2}};
  private final double[] b = {2.4, 3.5, -1.2};
  private final double EPSILON = 0.001; // точность

  LinearSystemModel viewModel;

  public LinearSystemInteractor(LinearSystemModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  // Расчет результата методом Гаусса.
  public void gaussMethod() {

    double[] result = GaussianEliminationSolver.solve(A, b, EPSILON);
    String resultString = "Корни СЛАУ: " + Arrays.toString(result);
    viewModel.setLinearSystemResult(resultString);
  }

  // Расчет результата методом простых итераций (методом Якоби).
  public void iterativeMethod() {

    double[] result = IterativeSolver.solve(A, b, EPSILON);
    String resultString = "Корни СЛАУ: " + Arrays.toString(result);
    viewModel.setLinearSystemResult(resultString);
  }

  // Расчет результата методом Зейделя.
  public void seidelMethod() {

    SeidelSolver gaussSeidel = new SeidelSolver(A, b);
    String resultString = "";
    if (!gaussSeidel.makeDominant()) {
      resultString = "Система не является диагонально доминирующей. Метод не гарантирует сходимость";
      System.out.println(resultString);
    }
    resultString = "Корни СЛАУ: " + Arrays.toString(gaussSeidel.solve());
    viewModel.setLinearSystemResult(resultString);
  }

}
