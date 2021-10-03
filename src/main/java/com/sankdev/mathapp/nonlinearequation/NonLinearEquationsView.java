package com.sankdev.mathapp.nonlinearequation;

import com.sankdev.mathapp.GUIUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NonLinearEquationsView extends VBox {

  NonLinearEquationsView(NonLinearEquationModel viewModel, Runnable halfDivisionMethodActionHandler,
      Runnable chordMethodActionHandler, Runnable tangentMethodActionHandler) {

    // Создаем дочерние элементы окна.
    // Левая группа элементов.
    VBox leftVBox = new VBox();
    Label infoLbl = new Label("Выберите метод для решения нелинейного уравнения:");
    Image nonLinearEquationImg = viewModel.getNonLinearEquationImg();
    ImageView nonLinearEquationImgView = new ImageView();
    nonLinearEquationImgView.setImage(nonLinearEquationImg);
    Label promptLbl = new Label("Вычислить");
    Button halfDivisionMethodBtn = new Button("Методом половинного деления");
    Button chordMethodBtn = new Button("Методом хорд");
    Button tangentMethodBtn = new Button("Методом касательных");
    leftVBox.getChildren()
        .addAll(infoLbl, nonLinearEquationImgView, promptLbl, halfDivisionMethodBtn, chordMethodBtn,
            tangentMethodBtn);
    GUIUtils.styleBoxPane(leftVBox);
    for(Node tempNode : leftVBox.getChildren()) {
      if (tempNode instanceof Button) {
        ((Button) tempNode).setPrefWidth(300);
      }
    }
    // Правая группа элементов.
    VBox rightVBox = new VBox();
    Label placeholderLbl = new Label(" ");
    Label resultLbl = new Label("Результат: ");
    TextField resultTxt = new TextField();
    // ! Связываем содержимое текстового поля с атрибутом модели.
    resultTxt.textProperty()
        .bindBidirectional(viewModel.nonLinearEquationResultProperty());
    rightVBox.getChildren().addAll(placeholderLbl, resultLbl, resultTxt);
    GUIUtils.styleBoxPane(rightVBox);
    // Дополнительный контейнер.
    HBox hBox = new HBox();
    hBox.getChildren().addAll(leftVBox, rightVBox);
    GUIUtils.styleBoxPane(hBox);

    // Добавляем обработчики событий.
    halfDivisionMethodBtn.setOnAction(event -> halfDivisionMethodActionHandler.run());
    chordMethodBtn.setOnAction(event -> chordMethodActionHandler.run());
    tangentMethodBtn.setOnAction(event -> tangentMethodActionHandler.run());

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().addAll(hBox);

    // Стилизуем контейнер.
    GUIUtils.styleBoxPane(this);

  }

}
