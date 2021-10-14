package com.sankdev.mathapp.nonlinearsystem;

import com.sankdev.mathapp.GUIUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NonLinearSystemView extends VBox {

  NonLinearSystemView(NonLinearSystemModel viewModel, Runnable simpleIterativeMethod,
      Runnable newtonMethodActionHandler) {

    // Создаем дочерние элементы окна.
    // Левая группа элементов.
    VBox leftVBox = new VBox();
    Label infoLbl = new Label("Выберите метод для решения СНУ:");
    Image nonLinearSystemImg = viewModel.getNonLinearSystemImg();
    ImageView nonLinearSystemImgView = new ImageView();
    nonLinearSystemImgView.setImage(nonLinearSystemImg);
    Label promptLbl = new Label("Вычислить");
    Button simpleIterativeMethodBtn = new Button("Методом простых итераций");
    Button newtonMethodBtn = new Button("Методом Ньютона");
    leftVBox.getChildren()
        .addAll(infoLbl, nonLinearSystemImgView, promptLbl, simpleIterativeMethodBtn,
            newtonMethodBtn);
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
        .bindBidirectional(viewModel.nonLinearSystemResultProperty());
    rightVBox.getChildren().addAll(placeholderLbl, resultLbl, resultTxt);
    GUIUtils.styleBoxPane(rightVBox);
    // Дополнительный контейнер.
    HBox hBox = new HBox();
    hBox.getChildren().addAll(leftVBox, rightVBox);
    GUIUtils.styleBoxPane(hBox);

    // Добавляем обработчики событий.
    simpleIterativeMethodBtn.setOnAction(event -> simpleIterativeMethod.run());
    newtonMethodBtn.setOnAction(event -> newtonMethodActionHandler.run());

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().addAll(hBox);

    // Стилизуем контейнер.
    GUIUtils.styleBoxPane(this);

  }

}
