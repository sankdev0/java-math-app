package com.sankdev.mathapp.integration;

import java.util.Objects;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class IntegrationModel {

  public final ObjectProperty<Image> firstIntegrationImg = new SimpleObjectProperty<>();
  public final ObjectProperty<Image> secondIntegrationImg = new SimpleObjectProperty<>();

  public final StringProperty integrationResult = new SimpleStringProperty();

  public IntegrationModel() {
    String firstIntegrationImgUrl = Objects.requireNonNull(
        getClass().getResource("/com/sankdev/mathapp/img/img_8.png")).toString();
    this.firstIntegrationImg.setValue(new Image(firstIntegrationImgUrl));
    String secondIntegrationImgUrl = Objects.requireNonNull(
        getClass().getResource("/com/sankdev/mathapp/img/img_9.png")).toString();
    this.secondIntegrationImg.setValue(new Image(secondIntegrationImgUrl));
    this.integrationResult.set(" ");
  }

  public Image getFirstIntegrationImg() {
    return firstIntegrationImg.get();
  }

  public void setFirstIntegrationImg(Image firstIntegrationImg) {
    this.firstIntegrationImg.set(firstIntegrationImg);
  }

  public ObjectProperty<Image> firstIntegrationImgProperty() {
    return firstIntegrationImg;
  }

  public String getIntegrationResult() {
    return integrationResult.get();
  }

  public void setIntegrationResult(String integrationResult) {
    this.integrationResult.set(integrationResult);
  }

  public StringProperty integrationResultProperty() {
    return integrationResult;
  }

  public Image getSecondIntegrationImg() {
    return secondIntegrationImg.get();
  }

  public ObjectProperty<Image> secondIntegrationImgProperty() {
    return secondIntegrationImg;
  }

  public void setSecondIntegrationImg(Image secondIntegrationImg) {
    this.secondIntegrationImg.set(secondIntegrationImg);
  }
}
