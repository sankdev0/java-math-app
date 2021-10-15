package com.sankdev.mathapp.interpolation;

class InterpolationInteractor {

  InterpolationModel viewModel;

  public InterpolationInteractor(InterpolationModel viewModel) {
    this.viewModel = viewModel;
    // Здесь не нужны связи (binds) между элементами интерфейса, хотя обычно они здесь.
  }

  // Расчет результата методом простых итераций.
  public void lagrangePolynomial() {

    double result = LagrangePolynomial.getLagrangePolynomial(LagrangePolynomial.table,
        LagrangePolynomial.TARGET_X);
    String resultString =
        "Интерполяционная функция: " + LagrangePolynomial.getLagrangePolynomialString()
            + "\nЗначение в точке х " + LagrangePolynomial.TARGET_X + " F(3.5) = " + result;
    viewModel.setInterpolationResult(resultString);
  }

  // Расчет результата методом Ньютона.
  public void newtonPolynomial() {

    double result = NewtonPolynomial.getNewtonPolynomial();
    String resultString =
        "Интерполяционная функция: " + NewtonPolynomial.getNewtonPolynomialString()
            + "\nЗначение в точке х " + NewtonPolynomial.TARGET_X + " F(3.5) = " + result;
    viewModel.setInterpolationResult(resultString);
  }

}
