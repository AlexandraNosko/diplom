package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class Question2 {

    private String petsQuestion;

    private String pets;

    private String year;

    private String name;

    private String[] petsEat;

    public String getPetsQuestion() {
        return petsQuestion;
    }

    public void setPetsQuestion(String petsQuestion) {
        this.petsQuestion = petsQuestion;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPetsEat() {
        return petsEat;
    }

    public void setPetsEat(String[] petsEat) {
        this.petsEat = petsEat;
    }



}

