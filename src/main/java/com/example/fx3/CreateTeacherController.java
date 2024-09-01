package com.example.fx3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.Year;

public class CreateTeacherController {


    @FXML
    private ComboBox<TeacherCondition> cb_Condition;

    @FXML
    private ComboBox<String> cb_Group;

    @FXML
    private TextField tb_yearOfBirth;

    @FXML
    private TextField tb_Name;

    @FXML
    private TextField tb_Salary;

    @FXML
    private TextField tb_Surname;

    @FXML
    private Button Bt_CreateTeacher;

    @FXML
    public void initialize() {
        cb_Condition.getItems().addAll(TeacherCondition.values());
        cb_Group.getItems().addAll(ClassContainer.getInstance().getTeachersGroup());
    }

    @FXML
    void ButtonPressed(ActionEvent event){

        if(tb_Salary.getText().isEmpty() || tb_Surname.getText().isEmpty() || tb_Name.getText().isEmpty() || cb_Condition.getValue() == null || tb_yearOfBirth.getText().isEmpty() && CheckYearNumber(tb_yearOfBirth.getText())){
                return;
        }
        if(ClassContainer.getInstance().getCount() <= 0){
            return;
        }
        Teacher t = new Teacher(tb_Name.getText(), tb_Surname.getText(), (TeacherCondition) cb_Condition.getValue(), Integer.parseInt(tb_yearOfBirth.getText()), Integer.parseInt(tb_Salary.getText()));

        ClassContainer.getInstance().getClassTeacher(cb_Group.getValue()).addTeacher(t);
        returnToMain(event);

    }

    private boolean CheckYearNumber(String text){
        try{
            int number = Integer.parseInt(text);
            return number >= 1900 && number <= Year.now().getValue();

        } catch (NumberFormatException e){
            System.out.println("Invalid Year Number");
            return false;
        }

    }
    @FXML
    public void returnToMain(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Create Teacher");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
