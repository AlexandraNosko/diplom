package com.hotel.pages;

import com.hotel.models.Registration;
import com.hotel.models.Room;
import com.hotel.models.RoomType;
import com.hotel.models.Stage;
import com.hotel.repositories.RegistrationRepository;
import com.hotel.repositories.StageRepository;
import org.springframework.data.domain.Example;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Optional;

@Named
public class LoginPage {

    @Inject
    private RegistrationRepository registrationRepository;

    @Inject
    private StageRepository stageRepository;

    @PostConstruct
    public void init() {
        Stage stage = new Stage();
        stage.setNumber("1A");
        stage.setRooms(new ArrayList<>());
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();

        stage.getRooms().add(room1);
        stage.getRooms().add(room2);
        stage.getRooms().add(room3);
        stage.getRooms().add(room4);

        room1.setNumber("100");
        room1.setRoomType(RoomType.ECONOM);
        room1.setFree("2");
        room1.setStage(stage);

        room2.setNumber("101");
        room2.setRoomType(RoomType.ECONOM);
        room2.setFree("2");
        room2.setStage(stage);
        room3.setNumber("102");
        room3.setRoomType(RoomType.STANDART);
        room3.setFree("2");
        room3.setStage(stage);
        room4.setNumber("103");
        room4.setRoomType(RoomType.STANDART);
        room4.setFree("2");
        room4.setStage(stage);

        stageRepository.save(stage);

        Registration registration = new Registration();
        registration.setName("111");
        registration.setPassword("111");
        registrationRepository.save(registration);


        stage = new Stage();
        stage.setNumber("2A");
        stage.setRooms(new ArrayList<>());
        room1 = new Room();
        room2 = new Room();
        room3 = new Room();
        room4 = new Room();

        stage.getRooms().add(room1);
        stage.getRooms().add(room2);
        stage.getRooms().add(room3);
        stage.getRooms().add(room4);

        room1.setNumber("200");
        room1.setRoomType(RoomType.STANDART);
        room1.setFree("2");
        room1.setStage(stage);

        room2.setNumber("201");
        room2.setRoomType(RoomType.STANDART);
        room2.setFree("2");
        room2.setStage(stage);
        room3.setNumber("202");
        room3.setRoomType(RoomType.STANDART);
        room3.setFree("3");
        room3.setStage(stage);
        room4.setNumber("203");
        room4.setRoomType(RoomType.STANDART);
        room4.setFree("5");
        room4.setStage(stage);

        stageRepository.save(stage);
    }

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

        return "goToMenu";
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }


}
