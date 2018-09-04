package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class Login {
    private String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkPassword() {
        if (password.equals("password")) {
            setLogin(login);
            return "goToProfile";
        } else {
            sendMessage("Invalid password");
            return null;
        }
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message,null));

    }
}
