package com.sankdev.mathapp;

import javafx.scene.layout.Region;

public class MainWindowController {

  private final Region view;

  public MainWindowController() {
    view = new MainWindowView();
  }

  public Region getView() {
    return view;
  }
}
