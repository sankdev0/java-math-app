package com.sankdev.mathapp.integration;

import com.sankdev.mathapp.GUIUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IntegrationView extends VBox {

  IntegrationView(IntegrationModel viewModel, Runnable trapezoidalRuleActionHandler,
      Runnable simpsonsRuleActionHandler) {

    // Создаем дочерние элементы окна.
    // Левая группа элементов.
    VBox leftVBox = new VBox();
    Label infoLbl = new Label("Выберите правило для интегрирования:");
    Image firstIntegrationImg = viewModel.getFirstIntegrationImg();
    ImageView firstIntegrationImgView = new ImageView();
    firstIntegrationImgView.setImage(firstIntegrationImg);
    Image secondIntegrationImg = viewModel.getSecondIntegrationImg();
    ImageView secondIntegrationImgView = new ImageView();
    secondIntegrationImgView.setImage(secondIntegrationImg);
    Label firstPromptLbl = new Label("Вычислить");
    Label secondPromptLbl = new Label(firstPromptLbl.getText());
    Button trapezoidalRuleBtn = new Button("По правилу трапеций");
    Button simpsonsRuleBtn = new Button("По правилу Симпсона");
    leftVBox.getChildren().addAll(infoLbl, firstPromptLbl, firstIntegrationImgView, trapezoidalRuleBtn,
        secondPromptLbl, secondIntegrationImgView, simpsonsRuleBtn);
    GUIUtils.styleBoxPane(leftVBox);
    infoLbl.setPrefWidth(600);
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
        .bindBidirectional(viewModel.integrationResultProperty());
    rightVBox.getChildren().addAll(placeholderLbl, resultLbl, resultTxt);
    GUIUtils.styleBoxPane(rightVBox);
    // Дополнительный контейнер.
    HBox hBox = new HBox();
    hBox.getChildren().addAll(leftVBox, rightVBox);
    GUIUtils.styleBoxPane(hBox);

    // Добавляем обработчики событий.
    trapezoidalRuleBtn.setOnAction(event -> trapezoidalRuleActionHandler.run());
    simpsonsRuleBtn.setOnAction(event -> simpsonsRuleActionHandler.run());

    // Добавляем в контейнер дочерние элементы окна.
    getChildren().addAll(hBox);

    // Стилизуем контейнер.
    GUIUtils.styleBoxPane(this);

  }

}
