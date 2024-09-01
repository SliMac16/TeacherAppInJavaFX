package com.example.fx3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClassTeacher {
    String groupName;
    ArrayList<Teacher> TeachersList;
    int maxNumber;

    public ClassTeacher(String groupName,int maxNumber) {
        this.groupName = groupName;
        this.TeachersList = new ArrayList<>();
        this.maxNumber = maxNumber;
    }

    public void addTeacher(Teacher teacher){

    if(TeachersList.size() >= maxNumber){
        System.out.println("Nie można dodać więcej nauczycieli");
        return;
    }
    if(TeachersList.contains(teacher)){
        System.out.println("Nauczyciel o takim imieniu i nazwisku jest już dodany");
        return;
    }
        TeachersList.add(teacher);
        System.out.println("Nauczyciel został dodany" + teacher.getImie() + " " + teacher.getNazwisko());
    }
    private void Error(){
        System.out.println("Nauczyciel nie istnieje");
    }

    public void addSalary(Teacher teacher, double salary){
        if(TeachersList.contains(teacher)){
            teacher.wynagrodzenie += salary;
        }
    }

    public int getSize(){
        return TeachersList.size();
    }

    public int getMaxNumber(){
        return maxNumber;
    }

    public void removeTeacher(Teacher teacher){
        if(TeachersList.contains(teacher)){
            TeachersList.remove(teacher);
        }
        else{
            Error();
        }
    }

    public void changeCondition(Teacher teacher, TeacherCondition condition){
        if(!TeachersList.contains(teacher)){
            Error();
            return;
        }
        teacher.condition = condition;
    }

    public void search(String surname){
        for(Teacher teacher : TeachersList){
            if(teacher.nazwisko.equals(surname)){
                teacher.Printing();

            }
        }
    }

    public ArrayList<Teacher> searchPartial(String str){
        ArrayList<Teacher> temp = new ArrayList<>();
        for(Teacher teacher : TeachersList){
            if(teacher.nazwisko.contains(str)){
                temp.add(teacher);
            }
        }
        return temp;
    }

    public int countbyCondition(TeacherCondition condition){
        int number = 0;
        for(Teacher teacher : TeachersList){
            if(teacher.condition.equals(condition)){
                number++;
            }
        }
        return number;
    }

    public void summary(){
        for(Teacher teacher : TeachersList){
            teacher.Printing();
        }
    }

    public ArrayList<Teacher> sortByName(){
        ArrayList<Teacher> temp = new ArrayList<>();
        Collections.sort(TeachersList);
        return temp;
    }

    public ArrayList<Teacher> sortBySalary(){
        ArrayList<Teacher> temp = new ArrayList<>();
        temp.sort((d1,d2) -> Double.compare(d1.getWynagrodzenie(), d2.getWynagrodzenie()));
        return temp;

    }

    public Teacher max() {
        return Collections.max(TeachersList, Comparator.comparingDouble(Teacher::getWynagrodzenie));
    }



}