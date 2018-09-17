package com.example.demo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ProfilePage {

    @Inject
    public RegistrationRepository registrationRepository;

    public List<Registration> findAllUsers() {
        return registrationRepository.findAll();
    }


}
