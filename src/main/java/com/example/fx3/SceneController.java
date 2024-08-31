package com.example.fx3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToScene1(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("ListView.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToScene2(ActionEvent event) throws IOException {

    }
    @FXML
    void openCreateTeacherWindow(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("createTeachWindow.fxml"));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Create Teacher");
            stage.setScene(scene);
            stage.show();


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
