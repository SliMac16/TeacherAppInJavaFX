package com.example.fx3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<ClassTeacher> TV_main;

    @FXML
    private TableColumn<ClassTeacher, ?> tbColumn1;

    @FXML
    private TableColumn<?, ?> tbColumn2;

    @FXML
    public void initialize(){
        ClassContainer container = ClassContainer.getInstance();
        ObservableList<ClassTeacher> data = FXCollections.observableArrayList(container.getTeachersGroupMap().values());
        TV_main.setItems(data);
    }

    @FXML
    void Refresh(){
        if(ClassContainer.getInstance() == null){
            return;
        }
        //TV_main.getItems().addAll(FXCollections.observableList(ClassContainer.getInstance().getTeachersGroup()));
    }

    @FXML
    private void handleCreateClassTeacher(ActionEvent event) {
        // Tworzenie i wyświetlanie dialogu
        ClassTeacherDialog dialog = new ClassTeacherDialog();
        Optional<ClassTeacher> result = dialog.showAndWait();

        // Przetwarzanie wyniku
        result.ifPresent(classTeacher -> {
            // Pobieranie instancji ClassContainer
            ClassContainer container = ClassContainer.getInstance();

            // Dodanie nowego ClassTeacher do ClassContainer
            container.addClass(classTeacher.groupName, classTeacher.getMaxNumber());

            System.out.println("Added ClassTeacher: " + classTeacher.groupName + " to ClassContainer");
        });
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
