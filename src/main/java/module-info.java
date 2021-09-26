module com.sankdev.math.javamathapp {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.dlsc.formsfx;
  requires javafx.graphics;

  opens com.sankdev.mathapp to javafx.fxml;
  exports com.sankdev.mathapp;
}