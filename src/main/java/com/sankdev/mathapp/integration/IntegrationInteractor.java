package com.sankdev.mathapp.integration;

 class IntegrationInteractor {

  IntegrationModel viewModel;

  public IntegrationInteractor(IntegrationModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  // Расчет результата методом простых итераций.
  public void trapezoidalRule() {

    double result = TrapezoidalRule.integrate(1, 4, 8);
    String resultString =
        "Интеграл по правилу трапеций: " + result;
    viewModel.setIntegrationResult(resultString);
  }

}
