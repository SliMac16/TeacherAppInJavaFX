package com.example.fx3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassContainer {

    private static ClassContainer instance;

    Map<String, ClassTeacher> teachersGroup;

    private static int count = 0;

    private ClassContainer() {
        this.teachersGroup = new HashMap<>();
        System.out.println("New ClassContainer");
    }

    public static ClassContainer getInstance() {
        if (instance == null) {
            synchronized (ClassContainer.class) {
                if (instance == null) {
                    instance = new ClassContainer();
                }
            }
        }
        return instance;
    }

    public void addClass(String name, double maxNumber) {

        if (!teachersGroup.containsKey(name)) {
            teachersGroup.put(name, new ClassTeacher(name, (int) maxNumber));
            count++;
        } else {
            System.out.println("Grupa o takiej nazwie już istnieje.");

        }
    }
    public void removeClass(String nazwa) {
        teachersGroup.remove(nazwa);
        count--;
    }

    public ArrayList<String> findEmpty(){
        ArrayList<String> emptyGroups = new ArrayList<>();
        for(Map.Entry<String, ClassTeacher> entry : teachersGroup.entrySet()){
            if(entry.getValue().getSize() == 0){
                emptyGroups.add(entry.getKey());
            }
        }
        return emptyGroups;
    }

    public void summary() {
        for (Map.Entry<String, ClassTeacher> entry : teachersGroup.entrySet()) {
            String nazwa = entry.getKey();
            ClassTeacher classTeacher = entry.getValue();
            double percentFilled = (classTeacher.getSize() / (double) classTeacher.getMaxNumber()) * 100;
            System.out.println("Nazwa grupy: " + nazwa + ", Zapełnienie: " + percentFilled + "%");
        }
    }
    public ArrayList<String>  getTeachersGroup() {
        ArrayList<String> teachersGroupNames = new ArrayList<>();
        for (Map.Entry<String, ClassTeacher> entry : teachersGroup.entrySet()) {
            teachersGroupNames.add(entry.getKey());
            System.out.println(entry.getKey());
        }
        return teachersGroupNames;
    }

    public Map<String, ClassTeacher> getTeachersGroupMap() {
        return teachersGroup;
    }

    public ClassTeacher getClassTeacher(String nazwa) {
        return teachersGroup.get(nazwa);
    }

    public int getCount() {
        return count;
    }
}
