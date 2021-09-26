package com.sankdev.mathapp;

import java.util.Objects;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class NonLinearEquationModel {

  public final ObjectProperty<Image> nonLinearEquationImg = new SimpleObjectProperty<>();
  public final StringProperty nonLinearEquationResult = new SimpleStringProperty();

  public NonLinearEquationModel() {
    String nonLinearEquationImgUrl = Objects.requireNonNull(
        getClass().getResource("/com/sankdev/mathapp/img/img_4.png")).toString();
    this.nonLinearEquationImg.setValue(new Image(nonLinearEquationImgUrl));
    this.nonLinearEquationResult.set(" ");
  }

  public Image getNonLinearEquationImg() {
    return nonLinearEquationImg.get();
  }

  public ObjectProperty<Image> nonLinearEquationImgProperty() {
    return nonLinearEquationImg;
  }

  public String getNonLinearEquationResult() {
    return nonLinearEquationResult.get();
  }

  public StringProperty nonLinearEquationResultProperty() {
    return nonLinearEquationResult;
  }

  public void setNonLinearEquationResult(String nonLinearEquationResult) {
    this.nonLinearEquationResult.set(nonLinearEquationResult);
  }
}
