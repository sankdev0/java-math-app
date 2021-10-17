package com.sankdev.mathapp.differential;

import java.util.Objects;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class DifferentialModel {

  public final ObjectProperty<Image> differentialImg = new SimpleObjectProperty<>();
  public final StringProperty differentailResult = new SimpleStringProperty();

  public DifferentialModel() {
    String nonLinearEquationImgUrl = Objects.requireNonNull(
        getClass().getResource("/com/sankdev/mathapp/img/img_10.png")).toString();
    this.differentialImg.setValue(new Image(nonLinearEquationImgUrl));
    this.differentailResult.set(" ");
  }

  public Image getDifferentialImg() {
    return differentialImg.get();
  }

  public void setDifferentialImg(Image differentialImg) {
    this.differentialImg.set(differentialImg);
  }

  public ObjectProperty<Image> differentialImgProperty() {
    return differentialImg;
  }

  public String getDifferentailResult() {
    return differentailResult.get();
  }

  public void setDifferentailResult(String differentailResult) {
    this.differentailResult.set(differentailResult);
  }

  public StringProperty differentailResultProperty() {
    return differentailResult;
  }
}
