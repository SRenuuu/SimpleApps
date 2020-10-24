package number_converter;

import com.jfoenix.controls.JFXComboBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static javafx.application.Application.launch;

public class AppInitializer extends Application {
    @FXML public JFXComboBox cmbBxInputType;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/number_converter/Main.fxml"));
        primaryStage.setTitle("Number Systems Converter");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();


    }

}
