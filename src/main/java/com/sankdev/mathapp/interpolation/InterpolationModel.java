package com.sankdev.mathapp.interpolation;

import java.util.Objects;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class InterpolationModel {

  public final ObjectProperty<Image> interpolationImg = new SimpleObjectProperty<>();
  public final StringProperty interpolationResult = new SimpleStringProperty();

  public InterpolationModel() {
    String nonLinearEquationImgUrl = Objects.requireNonNull(
        getClass().getResource("/com/sankdev/mathapp/img/img_7.png")).toString();
    this.interpolationImg.setValue(new Image(nonLinearEquationImgUrl));
    this.interpolationResult.set(" ");
  }

  public Image getInterpolationImg() {
    return interpolationImg.get();
  }

  public void setInterpolationImg(Image interpolationImg) {
    this.interpolationImg.set(interpolationImg);
  }

  public ObjectProperty<Image> interpolationImgProperty() {
    return interpolationImg;
  }

  public String getInterpolationResult() {
    return interpolationResult.get();
  }

  public void setInterpolationResult(String interpolationResult) {
    this.interpolationResult.set(interpolationResult);
  }

  public StringProperty interpolationResultProperty() {
    return interpolationResult;
  }
}
