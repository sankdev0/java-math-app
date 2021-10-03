package com.sankdev.mathapp.linearsystem;

import java.util.Objects;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class LinearSystemModel {

  public final ObjectProperty<Image> linearSystemImg = new SimpleObjectProperty<>();
  public final StringProperty linearSystemResult = new SimpleStringProperty();

  public LinearSystemModel() {
    String nonLinearEquationImgUrl = Objects.requireNonNull(
        getClass().getResource("/com/sankdev/mathapp/img/img_5.png")).toString();
    this.linearSystemImg.setValue(new Image(nonLinearEquationImgUrl));
    this.linearSystemResult.set(" ");
  }

  public Image getLinearSystemImg() {
    return linearSystemImg.get();
  }

  public ObjectProperty<Image> linearSystemImgProperty() {
    return linearSystemImg;
  }

  public void setLinearSystemImg(Image linearSystemImg) {
    this.linearSystemImg.set(linearSystemImg);
  }

  public String getLinearSystemResult() {
    return linearSystemResult.get();
  }

  public StringProperty linearSystemResultProperty() {
    return linearSystemResult;
  }

  public void setLinearSystemResult(String linearSystemResult) {
    this.linearSystemResult.set(linearSystemResult);
  }
}
