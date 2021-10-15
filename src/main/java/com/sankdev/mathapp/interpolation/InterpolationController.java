package com.sankdev.mathapp.interpolation;

import javafx.scene.layout.Region;

public class InterpolationController {

  private Region view;

  public InterpolationController() {
    InterpolationModel viewModel = new InterpolationModel();
    InterpolationInteractor interpolationInteractor = new InterpolationInteractor(viewModel);
    view = new InterpolationView(viewModel, interpolationInteractor::lagrangePolynomial,
        interpolationInteractor::newtonPolynomial);
  }

  public Region getView() {
    return view;
  }
}
