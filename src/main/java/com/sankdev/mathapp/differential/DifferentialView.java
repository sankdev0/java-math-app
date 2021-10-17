package com.sankdev.mathapp.differential;

import com.sankdev.mathapp.GUIUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DifferentialView extends VBox {

  DifferentialView(DifferentialModel viewModel, Runnable rungeKuttaActionHandler) {

    // Создаем дочерние элементы окна.
    // Левая группа элементов.
    VBox leftVBox = new VBox();
    Label infoLbl = new Label("ОДУ:");
    Image differentialImg = viewModel.getDifferentialImg();
    ImageView differentialImgView = new ImageView();
    differentialImgView.setImage(differentialImg);
    Button rungeKuttaBtn = new Button("Вычислить");
    leftVBox.getChildren().addAll(infoLbl, differentialImgView, rungeKuttaBtn);
    GUIUtils.styleBoxPane(leftVBox);
    for (Node tempNode : leftVBox.getChildren()) {
      if (tempNode instanceof Button) {
        ((Button) tempNode).setPrefWidth(300);
      }
    }
    // Правая группа элементов.
    VBox rightVBox = new VBox();
    Label placeholderLbl = new Label(" ");
    Label resultLbl = new Label("Результат: ");
    TextArea resultTxt = new TextArea();
    resultTxt.setWrapText(true);
    // ! Связываем содержимое текстового поля с атрибутом модели.
    resultTxt.textProperty()
        .bindBidirectional(viewModel.differentailResultProperty());
    rightVBox.getChildren().addAll(placeholderLbl, resultLbl, resultTxt);
    GUIUtils.styleBoxPane(rightVBox);
    // Дополнительный контейнер.
    HBox hBox = new HBox();
    hBox.getChildren().addAll(leftVBox, rightVBox);
    GUIUtils.styleBoxPane(hBox);

    // Добавляем обработчики событий.
    rungeKuttaBtn.setOnAction(event -> rungeKuttaActionHandler.run());

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().addAll(hBox);

    // Стилизуем контейнер.
    GUIUtils.styleBoxPane(this);

  }

}
