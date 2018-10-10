package com.hotel.pages;

import com.hotel.models.Room;
import com.hotel.models.RoomType;
import com.hotel.models.Stage;
import com.hotel.repositories.RoomRepository;
import com.hotel.repositories.StageRepository;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@ViewScoped
public class AddRoomPage {

    @Inject
    private RoomRepository roomRepository;

    @Inject
    private StageRepository stageRepository;

    private String roomNumber;

    private RoomType roomType;

    private String freeBerth;

    private Stage stage;

    private String selectedStageId;

    private Map<String, String> stageList = new HashMap<>();

    @PostConstruct
    public void init() {
        for (Stage stage : stageRepository.findAll()) {
            stageList.put(stage.getNumber(), String.valueOf(stage.getId()));
        }
    }

    public Map<String, String> getStageList() {
        return stageList;
    }

    public void setStageList(Map<String, String> stageList) {
        this.stageList = stageList;
    }

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

    public String getSelectedStageId() {
        return selectedStageId;
    }

    public void setSelectedStageId(String selectedStageId) {
        this.selectedStageId = selectedStageId;
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
        if (roomType != null && roomType.equals(" ")){
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

        stageRepository.findAll();
        Stage stage = stageRepository.findById(1L).get();

        Room room = new Room();
        room.setNumber(roomNumber);
        room.setStage(stage);
        room.setRoomType(roomType);
        room.setFreeBerth(freeBerth);
        roomRepository.save(room);
        sendMessage("Комната успешно сохранена");
        return "goToMenu";
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));

    }
}
