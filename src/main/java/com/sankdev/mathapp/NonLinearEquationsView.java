package com.sankdev.mathapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NonLinearEquationsView extends VBox {

  NonLinearEquationsView(NonLinearEquationModel theNonLinearEquationModel, Runnable actionHandler) {

    // Создаем дочерние элементы окна.
    // Левая группа элементов.
    VBox leftVBox = new VBox();
    Label infoLbl = new Label("Выберите метод для решения нелинейного уравнения:");
    Image nonLinearEquationImg = theNonLinearEquationModel.getNonLinearEquationImg();
    ImageView nonLinearEquationImgView = new ImageView();
    nonLinearEquationImgView.setImage(nonLinearEquationImg);
    Label promptLbl = new Label("Вычислить");
    Button halfDivisionMethodBtn = new Button("Методом половинного деления");
    leftVBox.getChildren()
        .addAll(infoLbl, nonLinearEquationImgView, promptLbl, halfDivisionMethodBtn);
    GUIUtils.styleBoxPane(leftVBox);
    // Правая группа элементов.
    VBox rightVBox = new VBox();
    Label resultLbl = new Label("Результат: ");
    TextField resultTxt = new TextField();
    // ! Связываем содержимое текстового поля с атрибутом модели.
    resultTxt.textProperty().bindBidirectional(theNonLinearEquationModel.nonLinearEquationResultProperty());
    rightVBox.getChildren().addAll(resultLbl, resultTxt);
    GUIUtils.styleBoxPane(rightVBox);
    // Дополнительный контейнер.
    HBox hBox = new HBox();
    hBox.getChildren().addAll(leftVBox, rightVBox);
    GUIUtils.styleBoxPane(hBox);

    // Добавляем обработчики событий.
    halfDivisionMethodBtn.setOnAction(event -> actionHandler.run());

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().addAll(hBox);

    // Стилизуем контейнер.
    GUIUtils.styleBoxPane(this);

  }

}
