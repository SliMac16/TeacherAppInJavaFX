package com.example.fx3;

import java.util.ArrayList;

public class SingletonArray {
    private ArrayList<Teacher> teachersArr;
    private static SingletonArray instance;

    private SingletonArray(){
        teachersArr = new ArrayList<>();
    }

    public static SingletonArray getInstance(){
        if(instance == null){
            instance = new SingletonArray();
        }
        return instance;
    }

    public ArrayList<Teacher> getTeachersArr() {
        return teachersArr;
    }

    public void addTeacher(Teacher teacher){
        teachersArr.add(teacher);
    }
}
