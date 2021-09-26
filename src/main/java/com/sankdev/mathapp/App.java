package com.sankdev.mathapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  private static final double width = 350;
  public static final double height = 300;

  @Override
  public void start(Stage stage) throws Exception {

    // Создаем окно и запускаем его.
    Scene scene = new Scene(new MainWindowController().getView(), width, height);
    stage.setTitle("Пакет прикладных программ");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch();
  }
}
