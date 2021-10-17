package com.sankdev.mathapp.differential;

import javafx.scene.layout.Region;

public class DifferentialController {

  private Region view;

  public DifferentialController() {
    DifferentialModel viewModel = new DifferentialModel();
    DifferentialInteractor differentialInteractor = new DifferentialInteractor(viewModel);
    view = new DifferentialView(viewModel, differentialInteractor::RungeKutta);
  }

  public Region getView() {
    return view;
  }
}
