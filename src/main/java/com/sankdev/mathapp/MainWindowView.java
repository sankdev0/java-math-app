package com.sankdev.mathapp;

import com.sankdev.mathapp.linearsystem.LinearSystemController;
import com.sankdev.mathapp.nonlinearequation.NonLinearEquationController;
import com.sankdev.mathapp.nonlinearsystem.NonLinearSystemController;
import javafx.scene.Node;
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
    Button linearSystemsBtn = new Button("Решение СЛАУ");
    Button nonLinearSystemsBtn = new Button("Решение СНУ");

    // Добавляем обработчики событий.
    nonLinearEquationsBtn.setOnAction(event -> {
      Stage stage = new Stage();
      stage.setTitle("Нелинейное уравнение");
      stage.initModality(Modality.APPLICATION_MODAL);

      Scene scene = new Scene(new NonLinearEquationController().getView(),
          GUIUtils.BASE_WINDOW_WIDTH, GUIUtils.BASE_WINDOW_HEIGHT);
      stage.setScene(scene);
      stage.show();
    });
    linearSystemsBtn.setOnAction(event -> {
      Stage stage = new Stage();
      stage.setTitle("СЛАУ");
      stage.initModality(Modality.APPLICATION_MODAL);

      Scene scene = new Scene(new LinearSystemController().getView(), GUIUtils.BASE_WINDOW_WIDTH,
          GUIUtils.BASE_WINDOW_HEIGHT);
      stage.setScene(scene);
      stage.show();
    });
    nonLinearSystemsBtn.setOnAction(event -> {
      Stage stage = new Stage();
      stage.setTitle("СНУ");
      stage.initModality(Modality.APPLICATION_MODAL);

      Scene scene = new Scene(new NonLinearSystemController().getView(), GUIUtils.BASE_WINDOW_WIDTH,
          GUIUtils.BASE_WINDOW_HEIGHT);
      stage.setScene(scene);
      stage.show();
    });

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().setAll(infoLbl, nonLinearEquationsBtn, linearSystemsBtn, nonLinearSystemsBtn);

    // Стилизуем элементы главного окна.
    GUIUtils.styleBoxPane(this);
    for (Node tempNode : this.getChildren()) {
      if (tempNode instanceof Button) {
        ((Button) tempNode).setPrefWidth(300);
      }
    }
  }
}
