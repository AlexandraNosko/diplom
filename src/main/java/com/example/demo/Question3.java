package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class Question3 {

    private String[] season;

    private String city;

    private String food;

    private String moviesOr;

    private String color;


    public String[] getSeason() {
        return season;
    }

    public void setSeason(String[] season) {
        this.season = season;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMoviesOr() {
        return moviesOr;
    }

    public void setMoviesOr(String moviesOr) {
        this.moviesOr = moviesOr;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String goToNextPage() {
        if (season != null && season.length == 0) {
            sendMessage("Нужно выбрать любимое время года");
            return null;
        }
        if (city != null && city.equals("")) {
            sendMessage("Нужно ввести название любимого города");
            return null;
        }
        if (food != null && food.equals("")) {
            sendMessage("Нужно записать любимое блюдо");
            return null;
        }
        if (moviesOr != null && moviesOr.equals("")) {
            sendMessage("Выбери что больше предпочитаешь: фильмы или мультфильмы?");
            return null;
        }
        if (color != null && color.equals("0")) {
            sendMessage("Выбери любимый цвет");
            return null;
        }

        return "goToAnswers";

    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}