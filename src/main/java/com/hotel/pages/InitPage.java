package com.hotel.pages;

import com.hotel.models.Registration;
import com.hotel.models.Room;
import com.hotel.models.RoomType;
import com.hotel.models.Stage;
import com.hotel.repositories.RegistrationRepository;
import com.hotel.repositories.StageRepository;
import org.apache.commons.lang3.time.DateUtils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;

@Named
public class InitPage {

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
        room1.setArrivalDate(DateUtils.addDays(new Date(), -20));
        room1.setDepartureDate(DateUtils.addDays(new Date(), 20));
        room1.setGuestsCount(2);
        room1.setRoomType(RoomType.ECONOM);
        room1.setTotalNumberOfSeats(6);
        room1.setCost(400);
        room1.setPaid(400);
        room1.setStage(stage);

        room2.setNumber("101");
        room2.setArrivalDate(DateUtils.addDays(new Date(), -4));
        room2.setDepartureDate(DateUtils.addDays(new Date(), 5));
        room2.setGuestsCount(3);
        room2.setRoomType(RoomType.ECONOM);
        room2.setTotalNumberOfSeats(6);
        room2.setCost(500);
        room2.setPaid(400);
        room2.setStage(stage);

        room3.setNumber("102");
        room3.setGuestsCount(0);
        room3.setRoomType(RoomType.ECONOM);
        room3.setTotalNumberOfSeats(6);
        room3.setCost(500);
        room3.setPaid(0);
        room3.setStage(stage);

        room4.setNumber("103");
        room4.setGuestsCount(0);
        room4.setRoomType(RoomType.STANDART);
        room4.setTotalNumberOfSeats(2);
        room4.setCost(550);
        room4.setPaid(0);
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
        room1.setArrivalDate(DateUtils.addDays(new Date(), -7));
        room1.setDepartureDate(DateUtils.addDays(new Date(), 5));
        room1.setGuestsCount(2);
        room1.setRoomType(RoomType.STANDART);
        room1.setTotalNumberOfSeats(3);
        room1.setCost(550);
        room1.setPaid(400);
        room1.setStage(stage);

        room2.setNumber("201");
        room2.setArrivalDate(DateUtils.addDays(new Date(), -9));
        room2.setDepartureDate(DateUtils.addDays(new Date(), 1));
        room2.setGuestsCount(2);
        room2.setRoomType(RoomType.STANDART);
        room2.setTotalNumberOfSeats(3);
        room2.setCost(600);
        room2.setPaid(400);
        room2.setStage(stage);

        room3.setNumber("202");
        room3.setGuestsCount(0);
        room3.setRoomType(RoomType.STANDART);
        room3.setTotalNumberOfSeats(4);
        room3.setCost(700);
        room3.setPaid(0);
        room3.setStage(stage);

        room4.setNumber("203");
        room4.setGuestsCount(0);
        room4.setRoomType(RoomType.STANDART);
        room4.setTotalNumberOfSeats(4);
        room4.setCost(900);
        room4.setPaid(0);
        room4.setStage(stage);

        stageRepository.save(stage);

        stage = new Stage();
        stage.setNumber("3A");
        stage.setRooms(new ArrayList<>());
        room1 = new Room();
        room2 = new Room();

        stage.getRooms().add(room1);
        stage.getRooms().add(room2);

        room1.setNumber("300");
        room1.setGuestsCount(0);
        room1.setRoomType(RoomType.VIP);
        room1.setTotalNumberOfSeats(2);
        room1.setCost(2000);
        room1.setPaid(0);
        room1.setStage(stage);

        room2.setNumber("301");
        room2.setArrivalDate(DateUtils.addDays(new Date(), -5));
        room2.setDepartureDate(new Date());
        room2.setGuestsCount(3);
        room2.setRoomType(RoomType.VIP);
        room2.setTotalNumberOfSeats(5);
        room2.setCost(3000);
        room2.setPaid(2500);
        room2.setStage(stage);

        stageRepository.save(stage);
    }

}
