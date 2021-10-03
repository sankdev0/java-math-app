module com.sankdev.math.javamathapp {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.dlsc.formsfx;
  requires javafx.graphics;

  opens com.sankdev.mathapp to javafx.fxml;
  exports com.sankdev.mathapp;
  exports com.sankdev.mathapp.linearsystem;
  opens com.sankdev.mathapp.linearsystem to javafx.fxml;
  exports com.sankdev.mathapp.nonlinearequation;
  opens com.sankdev.mathapp.nonlinearequation to javafx.fxml;
}