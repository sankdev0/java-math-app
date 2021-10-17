package com.sankdev.mathapp.integration;

class IntegrationInteractor {

  IntegrationModel viewModel;

  public IntegrationInteractor(IntegrationModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  // Расчет нтеграла по правилу трапеций (аппроксимация прямыми).
  public void trapezoidalRule() {

    double result = TrapezoidalRule.integrate(1, 4, 8);
    String resultString =
        "Интеграл по правилу трапеций: " + result;
    viewModel.setIntegrationResult(resultString);
  }

  // Расчет интеграла по правилу Симпсона (аппроксимация параболами).
  public void simpsonsRule() {

    double result = SimpsonsRule.integrate(1, 2, 8);
    String resultString =
        "Интеграл по правилу Симпсона: " + result;
    viewModel.setIntegrationResult(resultString);
  }
}
