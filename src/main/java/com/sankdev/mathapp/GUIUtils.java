package com.sankdev.mathapp;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GUIUtils {

  public static final Font BASE_TXT_FONT = Font.font(Font.getDefault().getName(),
      Font.getDefault().getSize() * 1.3);
  public static final Font BASE_BTN_FONT = Font.font(Font.getDefault().getName(),
      Font.getDefault().getSize() * 1.2);
  public static final Font BASE_BOLD_FONT = Font.font(Font.getDefault().getName(), FontWeight.BOLD,
      Font.getDefault().getSize() * 1.3);
  public static final int DEFAULT_SPACING = 10;
  public static final double BASE_WINDOW_WIDTH = 700;
  public static final double BASE_WINDOW_HEIGHT = 400;
  public static Insets DEFAULT_INSETS = new Insets(5);

  public static void styleLabeled(Labeled labeled, Font theFont) {
    labeled.setFont(theFont);
  }

  public static void styleTextInputControl(TextInputControl textInputControl, Font theFont) {
    textInputControl.setFont(theFont);
  }

  // Style all children of the pane using simple default styles.
  // Used to style VBox or HBox container.
  public static void styleBoxPane(Pane pane) {

    pane.setPadding(DEFAULT_INSETS);

    if (pane instanceof VBox) {
      ((VBox) pane).setSpacing(DEFAULT_SPACING);
    }

    if (pane instanceof HBox) {
      ((HBox) pane).setSpacing(DEFAULT_SPACING);
    }

    List<Node> nodes = pane.getChildren();
    for (Node tempNode : nodes) {
      if (tempNode instanceof Button) {
        styleLabeled((Button) tempNode, BASE_BTN_FONT);
      }
      if (tempNode instanceof Label) {
        styleLabeled((Label) tempNode, BASE_TXT_FONT);
      }
      if (tempNode instanceof TextField || tempNode instanceof TextArea) {
        styleTextInputControl((TextInputControl) tempNode, BASE_TXT_FONT);
      }
    }
  }

}
