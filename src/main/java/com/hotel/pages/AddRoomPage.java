package com.hotel.pages;

import com.hotel.models.Room;
import com.hotel.models.RoomType;
import com.hotel.models.Stage;
import com.hotel.repositories.RoomRepository;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AddRoomPage {

    @Inject
    private RoomRepository roomRepository;

    private String roomNumber;

    private RoomType roomType;

    private String freeBerth;

    private Stage stage;

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }

    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getFreeBerth() {
        return freeBerth;
    }

    public void setFreeBerth(String freeBerth) {
        this.freeBerth = freeBerth;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String addRoom() {
        if (roomNumber != null && roomNumber.equals("")) {
            sendMessage("Введите номер комнаты");
            return null;
        }
        if (roomType != null && roomType.equals("")){
            sendMessage("Введите тип комнаты");
            return null;
        }
        if (freeBerth != null && freeBerth.equals("")){
            sendMessage("Введите количество мест в комнате");
            return null;
        }
        if (stage != null && stage.equals("")){
            sendMessage("Введите номер этажа");
            return null;
        }
        Room room = new Room();
        room.setNumber(roomNumber);
        room.setRoomType(roomType);
        room.setFreeBerth(freeBerth);
        room.setStage(stage);
        roomRepository.save(room);
        sendMessage("Комната успешно сохранена");
        return "goToMenu";
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));

    }
}
