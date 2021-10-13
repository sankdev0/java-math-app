package com.sankdev.mathapp.nonlinearsystem;

import java.util.Objects;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class NonLinearSystemModel {

  public final ObjectProperty<Image> nonLinearSystemImg = new SimpleObjectProperty<>();
  public final StringProperty nonLinearSystemResult = new SimpleStringProperty();

  public NonLinearSystemModel() {
    String nonLinearEquationImgUrl = Objects.requireNonNull(
        getClass().getResource("/com/sankdev/mathapp/img/img_6.png")).toString();
    this.nonLinearSystemImg.setValue(new Image(nonLinearEquationImgUrl));
    this.nonLinearSystemResult.set(" ");
  }

  public Image getNonLinearSystemImg() {
    return nonLinearSystemImg.get();
  }

  public ObjectProperty<Image> nonLinearSystemImgProperty() {
    return nonLinearSystemImg;
  }

  public void setNonLinearSystemImg(Image nonLinearSystemImg) {
    this.nonLinearSystemImg.set(nonLinearSystemImg);
  }

  public String getNonLinearSystemResult() {
    return nonLinearSystemResult.get();
  }

  public StringProperty nonLinearSystemResultProperty() {
    return nonLinearSystemResult;
  }

  public void setNonLinearSystemResult(String nonLinearSystemResult) {
    this.nonLinearSystemResult.set(nonLinearSystemResult);
  }
}
