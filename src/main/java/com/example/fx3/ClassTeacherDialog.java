package com.example.fx3;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class ClassTeacherDialog extends Dialog<ClassTeacher> {

    private TextField groupNameField;
    private TextField maxNumberField;

    public ClassTeacherDialog() {
        setTitle("Create ClassTeacher");

        // Ustawienie typów przycisków
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Tworzenie pól tekstowych
        groupNameField = new TextField();
        groupNameField.setPromptText("Group Name");

        maxNumberField = new TextField();
        maxNumberField.setPromptText("Max Number");

        // Tworzenie układu
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new javafx.scene.control.Label("Group Name:"), 0, 0);
        grid.add(groupNameField, 1, 0);
        grid.add(new javafx.scene.control.Label("Max Number:"), 0, 1);
        grid.add(maxNumberField, 1, 1);

        getDialogPane().setContent(grid);

        // Konfiguracja, aby zwrócić wynik w przypadku zatwierdzenia
        setResultConverter(new Callback<ButtonType, ClassTeacher>() {
            @Override
            public ClassTeacher call(ButtonType dialogButton) {
                if (dialogButton == ButtonType.OK) {
                    String groupName = groupNameField.getText();

                    // Sprawdzanie poprawności wprowadzonej wartości
                    if (groupName == null || groupName.trim().isEmpty()) {
                        return null;  // Zwróć null, jeśli nazwa grupy jest pusta
                    }

                    String maxNumberText = maxNumberField.getText();
                    if (maxNumberText == null || maxNumberText.trim().isEmpty()) {
                        return null;  // Zwróć null, jeśli maxNumber jest pusty
                    }

                    // Sprawdzanie, czy maxNumber jest poprawną liczbą całkowitą
                    if (!maxNumberText.matches("\\d+")) {
                        return null;  // Zwróć null, jeśli nie jest to liczba całkowita
                    }

                    int maxNumber = Integer.parseInt(maxNumberText);

                    ClassTeacher classTeacher = new ClassTeacher(groupName, maxNumber);
                    return classTeacher;
                }
                return null;
            }
        });
    }
}
