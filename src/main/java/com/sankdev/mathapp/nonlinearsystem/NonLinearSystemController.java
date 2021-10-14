package com.sankdev.mathapp.nonlinearsystem;

import javafx.scene.layout.Region;

public class NonLinearSystemController {

  private Region view;

  public NonLinearSystemController() {
    NonLinearSystemModel viewModel = new NonLinearSystemModel();
    NonLinearSystemInteractor nonLinearSystemInteractor = new NonLinearSystemInteractor(viewModel);
    view = new NonLinearSystemView(viewModel, nonLinearSystemInteractor::simpleIterativeMethod,
        nonLinearSystemInteractor::newtonMethod);
  }

  public Region getView() {
    return view;
  }
}
