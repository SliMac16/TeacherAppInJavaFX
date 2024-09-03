package com.example.fx3;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClassTeacherDetailsController {

    @FXML
    private Label groupNameLabel;

    @FXML
    private Label maxNumberLabel;

    @FXML
    private TableView<Teacher> teachersTableView;

    @FXML
    private TableColumn<Teacher, String> teacherFirstNameColumn;

    @FXML
    private TableColumn<Teacher, String> teacherLastNameColumn;

    @FXML
    private TableColumn<Teacher, TeacherCondition> teacherConditionColumn;

    @FXML
    private TableColumn<Teacher, Integer> teacherYearOfBirthColumn;

    @FXML
    private TableColumn<Teacher, Double> teacherSalaryColumn;

    public void setClassTeacher(ClassTeacher classTeacher) {
        // Ustaw nazwę grupy i maksymalną liczbę nauczycieli
        groupNameLabel.setText(classTeacher.getGroupName());
        maxNumberLabel.setText(String.valueOf(classTeacher.getMaxNumber()));

        // Konfiguracja kolumny imienia
        teacherFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));

        // Konfiguracja kolumny nazwiska
        teacherLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));

        // Konfiguracja kolumny stanu nauczyciela
        teacherConditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));

        // Konfiguracja kolumny roku urodzenia
        teacherYearOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("rokUrodzenia"));

        // Konfiguracja kolumny wynagrodzenia
        teacherSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("wynagrodzenie"));

        // Załaduj nauczycieli do TableView
        teachersTableView.setItems(FXCollections.observableArrayList(classTeacher.getTeachersList()));


        System.out.println("Liczba nauczycieli w grupie: " + classTeacher.getTeachersList().size());
    }
}
