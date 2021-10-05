package com.sankdev.mathapp.linearsystem;

import javafx.scene.layout.Region;

public class LinearSystemController {

  private Region view;

  public LinearSystemController() {
    LinearSystemModel viewModel = new LinearSystemModel();
    LinearSystemInteractor linearSystemInteractor = new LinearSystemInteractor(viewModel);
    view = new LinearSystemView(viewModel, linearSystemInteractor::gaussMethod,
        linearSystemInteractor::iterativeMethod, null);
  }

  public Region getView() {
    return view;
  }
}
