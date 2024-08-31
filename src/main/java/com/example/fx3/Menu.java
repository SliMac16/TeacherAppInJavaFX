package com.example.fx3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class Menu extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),Color.BLACK );
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        ArrayList<Teacher> teachers = new ArrayList<>();
    }
}