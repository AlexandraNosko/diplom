package com.example.demo;

import org.springframework.data.domain.Example;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class RegistrationPage {

    @Inject
    private RegistrationRepository registrationRepository;

    private String name;
    private String password;
    private String verifyPassword;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String saveUserInformation() {
        if (name != null && name.equals("")) {
            sendMessage("Введите имя");
            return null;
        }
        if (password != null && password.equals("")) {
            sendMessage("Введите пароль");
            return null;
        }
        if (verifyPassword != null && !verifyPassword.equals(password)) {
            sendMessage("Пароли не совпадают");
            return null;
        }

        Registration example = new Registration();
        example.setName(name);
        Optional<Registration> exists = registrationRepository.findOne(Example.of(example));
        if (exists.isPresent()) {
            sendMessage("Такой логин уже существует");
            return null;
        }

        Registration registration = new Registration();
        registration.setName(name);
        registration.setPassword(password);
        registrationRepository.save(registration);
        return "goToLogin";
    }


    public void sendMessage(String message) {

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));

    }


}
