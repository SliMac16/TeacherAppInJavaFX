package com.example.fx3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.Year;

public class CreateTeacherController {


    @FXML
    private ComboBox<TeacherCondition> cb_Condition;

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
    }

    @FXML
    void ButtonPressed(ActionEvent event){

            if(tb_Salary.getText().isEmpty() || tb_Surname.getText().isEmpty() || tb_Name.getText().isEmpty() || cb_Condition.getValue() == null || tb_yearOfBirth.getText().isEmpty() && CheckYearNumber(tb_yearOfBirth.getText())){
                return;
            }
            Teacher t = new Teacher(tb_Name.getText(), tb_Surname.getText(), (TeacherCondition) cb_Condition.getValue(), Integer.parseInt(tb_yearOfBirth.getText()), Integer.parseInt(tb_Salary.getText()));



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
}
