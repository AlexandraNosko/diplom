package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Person {

    private String login;

    private int count;

    private String name;

    private String surname;

    private String year;

    private String gender;

//    private String login;
//
//    private String password;

    private String email;

//    public String checkPassword() {
//        if (password.equals("password")) {
//            return "goToProfile";
//        } else {
//            return "goToInvalidPassword";
//        }
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCount() {
        count++;
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

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

    //для отправки сообщения на сервер:
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



//    public void saveMessage() {
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        context.addMessage(null, new FacesMessage("Successful", "Your message: " + message));
//
//    }

}
