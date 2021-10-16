package com.sankdev.mathapp.integration;

import javafx.scene.layout.Region;

public class IntegrationController {

  private Region view;

  public IntegrationController() {
    IntegrationModel viewModel = new IntegrationModel();
    IntegrationInteractor integrationInteractor = new IntegrationInteractor(viewModel);
    view = new IntegrationView(viewModel, integrationInteractor::trapezoidalRule,
        integrationInteractor::simpsonsRule);
  }

  public Region getView() {
    return view;
  }
}
