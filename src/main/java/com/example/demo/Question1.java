package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class Question1 {

    private String name;
    private String surname;
    private String yearOfBirth;
    private String gender;
    private String[] language;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String  getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public String goToNextPage() {
        if (name != null && name.equals("")) {
            cleanFields();
            sendMessage("Введите имя");
            return null;
        }

        if (yearOfBirth != null && yearOfBirth.equals("")) {
            cleanFields();
            sendMessage("Выбрать дату рождения");
            return null;
        }

        if (gender != null && gender.equals("")) {
            cleanFields();
            sendMessage("Выбрать пол");
            return null;
        }

        if (surname != null && surname.equals("")) {
            cleanFields();
            sendMessage("Введите фамилию");
            return null;
        }

        if (language != null && language.length == 0) {
            cleanFields();
            sendMessage("Выбрать язык");
            return null;
        }

        return "goToQuestion2";
    }

    private void cleanFields() {
        name = "";
        yearOfBirth = "";
        gender = "";
        surname = "";
        language = new String[] {};
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message,null));

    }
}
