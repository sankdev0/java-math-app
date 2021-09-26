package com.sankdev.mathapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowView extends VBox {

  MainWindowView() {
    // Создаем дочерние элементы окна.
    Label infoLbl = new Label("Выберите приложение");
    Button nonLinearEquationsBtn = new Button("Решение нелинейных уравнений");

    // Добавляем обработчики событий.
    nonLinearEquationsBtn.setOnAction(event -> {
      Stage stage = new Stage();
      stage.setTitle("Нелинейное уравнение");
      stage.initModality(Modality.APPLICATION_MODAL);

      Scene scene = new Scene(new NonLinearEquationController().getView(), 650, 400);
      stage.setScene(scene);
      stage.show();
    });

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().setAll(infoLbl, nonLinearEquationsBtn);

    // Стилизуем элементы главного окна.
    GUIUtils.styleBoxPane(this);


  }
}
