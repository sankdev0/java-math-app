package com.sankdev.mathapp.linearsystem;

import com.sankdev.mathapp.GUIUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LinearSystemView extends VBox {

  LinearSystemView(LinearSystemModel viewModel, Runnable gaussMethodActionHandler,
      Runnable iterativeMethodActionHandler, Runnable seidelMethodActionHandler) {

    // Создаем дочерние элементы окна.
    // Левая группа элементов.
    VBox leftVBox = new VBox();
    Label infoLbl = new Label("Выберите метод для решения СЛАУ:");
    Image linearSystemImg = viewModel.getLinearSystemImg();
    ImageView linearSystemImgView = new ImageView();
    linearSystemImgView.setImage(linearSystemImg);
    Label promptLbl = new Label("Вычислить");
    Button linearSystemMethodBtn = new Button("Методом Гаусса");
    Button iterativeMethodBtn = new Button("Методом простых итераций");
    Button seidelMethodBtn = new Button("Методом Зейделя");
    leftVBox.getChildren()
        .addAll(infoLbl, linearSystemImgView, promptLbl, linearSystemMethodBtn, iterativeMethodBtn,
            seidelMethodBtn);
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
        .bindBidirectional(viewModel.linearSystemResultProperty());
    rightVBox.getChildren().addAll(placeholderLbl, resultLbl, resultTxt);
    GUIUtils.styleBoxPane(rightVBox);
    // Дополнительный контейнер.
    HBox hBox = new HBox();
    hBox.getChildren().addAll(leftVBox, rightVBox);
    GUIUtils.styleBoxPane(hBox);

    // Добавляем обработчики событий.
    linearSystemMethodBtn.setOnAction(event -> gaussMethodActionHandler.run());
    iterativeMethodBtn.setOnAction(event -> iterativeMethodActionHandler.run());
    seidelMethodBtn.setOnAction(event -> seidelMethodActionHandler.run());

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().addAll(hBox);

    // Стилизуем контейнер.
    GUIUtils.styleBoxPane(this);

  }

}
