module com.sankdev.math.javamathapp {
  requires javafx.controls;
  requires javafx.fxml;

  requires com.dlsc.formsfx;

  opens com.sankdev.mathapp to javafx.fxml;
  exports com.sankdev.mathapp;
}