package com.example.demo;

import org.springframework.data.domain.Example;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class LoginPage {

    @Inject
    private RegistrationPage registrationPage;

    @Inject
    private RegistrationRepository registrationRepository;


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

    public String doLogin() {
        Registration example = new Registration();
        example.setName(login);
        example.setPassword(password);
        Optional<Registration> exists = registrationRepository.findOne(Example.of(example));
        if (!exists.isPresent()) {
            sendMessage("Логин или пароль не правильны");
            return null;
        }

        return "goToProfile";
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }


}
