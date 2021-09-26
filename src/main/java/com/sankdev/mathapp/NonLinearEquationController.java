package com.sankdev.mathapp;

import javafx.scene.layout.Region;

public class NonLinearEquationController {

  private final Region view;

  public NonLinearEquationController() {
    NonLinearEquationModel viewModel = new NonLinearEquationModel();
    NonLinearEquationInteractor nonLinearEquationInteractor = new NonLinearEquationInteractor(viewModel);
    view = new NonLinearEquationsView(viewModel, nonLinearEquationInteractor::halfDivisionMethod);
  }

  public Region getView() {
    return view;
  }

}
