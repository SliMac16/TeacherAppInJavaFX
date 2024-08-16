package com.example.fx3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassContainer {

    Map<String, ClassTeacher> teachersGroup;

    ClassContainer() {
        this.teachersGroup = new HashMap<String, ClassTeacher>();
    }

    public void addClass(String name, double maxNumber) {

        if (!teachersGroup.containsKey(name)) {
            teachersGroup.put(name, new ClassTeacher(name, (int) maxNumber));
        } else {
            System.out.println("Grupa o takiej nazwie już istnieje.");

        }
    }
    public void removeClass(String nazwa) {
        teachersGroup.remove(nazwa);
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
}
