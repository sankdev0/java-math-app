package com.sankdev.mathapp.nonlinearequation;

import javafx.scene.layout.Region;

public class NonLinearEquationController {

  private final Region view;

  public NonLinearEquationController() {
    NonLinearEquationModel viewModel = new NonLinearEquationModel();
    NonLinearEquationInteractor nonLinearEquationInteractor = new NonLinearEquationInteractor(
        viewModel);
    view = new NonLinearEquationsView(viewModel, nonLinearEquationInteractor::halfDivisionMethod,
        nonLinearEquationInteractor::chordMethod, nonLinearEquationInteractor::tangentMethod);
  }

  public Region getView() {
    return view;
  }

}
