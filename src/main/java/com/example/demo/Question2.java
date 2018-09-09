package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Question2 {

    @Inject
    private Answers answers;

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

    public String goToNextPage() {
        if (petsQuestion != null && petsQuestion.equals("")) {
            cleanFields();
            sendMessage("Нет ответа на первый вопрос");
            return null;
        }

        if (petsQuestion != null && petsQuestion.equals("1")) {
            if (pets != null && pets.equals("")) {
                sendMessage("введите вид животного");
                return null;
            }
            if (name != null && name.equals("")) {
                sendMessage("Введите кличку животного");
                return null;
            }
            if (year != null && year.equals("0")) {
                sendMessage("Нужно выбрать возраст животного");
                return null;
            }
            if (petsEat != null && petsEat.length == 0) {
                sendMessage("Нужно выбрать чем Вы кормите ваше животное");
                return null;
            }
        }
        else if (petsQuestion != null && petsQuestion.equals("2")){
            return "goToQuestion3";
        }


        return "goToQuestion3";
    }

    private void cleanFields() {
        name = "";
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

}

