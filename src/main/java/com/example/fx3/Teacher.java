package com.example.fx3;

public class Teacher implements Comparable<Teacher>{
    String imie;
    String nazwisko;
    TeacherCondition condition;
    int rokUrodzenia;
    double wynagrodzenie;

    Teacher(String I,String n, TeacherCondition tc, int rok, double w){
        this.imie = I;
        this.nazwisko = n;
        this.condition = tc;
        this.rokUrodzenia = rok;
        this.wynagrodzenie = w;
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public TeacherCondition getCondition(){
        return condition;
    }


    public double getWynagrodzenie(){
        return this.wynagrodzenie;
    }

    public void Printing(){
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("stan: " + condition);
        System.out.println("rok urodzenia: " + rokUrodzenia);
        System.out.println("wynagrodzenie: " + wynagrodzenie);
    }

    @Override
    public int compareTo(Teacher o) {
       return this.nazwisko.compareTo(o.nazwisko);
    }

}
