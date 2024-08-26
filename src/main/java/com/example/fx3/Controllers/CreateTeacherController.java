package com.example.fx3.Controllers;


import com.example.fx3.Teacher;
import com.example.fx3.TeacherCondition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.Year;

public class CreateTeacherController {


    @FXML
    private ComboBox<?> cb_Condition;

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


    private void CreateTeacher(ActionEvent event) throws IOException {
        if(Bt_CreateTeacher.isPressed()){
            if(tb_Salary.getText().isEmpty() || tb_Surname.getText().isEmpty() || tb_Name.getText().isEmpty() || cb_Condition.getValue() == null || tb_yearOfBirth.getText().isEmpty() && CheckYearNumber(tb_yearOfBirth.getText())){}
            Teacher t = new Teacher(tb_Name.getText(), tb_Surname.getText(), (TeacherCondition) cb_Condition.getValue(), Integer.parseInt(tb_yearOfBirth.getText()), Integer.parseInt(tb_Salary.getText()) );
        }
    }

    private boolean CheckYearNumber(String text){
        boolean result = false;
        try{
            int number = Integer.parseInt(text);
            if(number >= 1900 && number <= Year.now().getValue()){
                result = true;
            }

        } catch (NumberFormatException e){
            System.out.println("Invalid Year Number");
        }
        finally {
            return result;
        }
    }
}
