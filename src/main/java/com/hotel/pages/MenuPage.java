package com.hotel.pages;

import com.hotel.models.Room;
import com.hotel.models.Stage;
import com.hotel.repositories.RoomRepository;
import com.hotel.repositories.StageRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.springframework.data.domain.Example;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Named
@ViewScoped
public class MenuPage implements Serializable {

    @Inject
    private StageRepository stageRepository;

    @Inject
    private RoomRepository roomRepository;

    private DefaultMenuModel menu;

    private String selectedRoomNumber;

    private Room selectedRoom;

    private String phoneNumber;

    private Date cleaningDate;

    @PostConstruct
    public void init() {
        menu = new DefaultMenuModel();

        List<Stage> stages = stageRepository.findAll();
        for (Stage stage : stages) {
            DefaultSubMenu stageMenu = new DefaultSubMenu(stage.getNumber());
            menu.addElement(stageMenu);

            if (stage.getRooms() == null) {
                continue;
            }

            for (Room room : stage.getRooms()) {
                DefaultMenuItem itemRoom = new DefaultMenuItem(createRoomTitle(room));
                itemRoom.setUrl("menu.xhtml?room=" + room.getNumber());
                stageMenu.addElement(itemRoom);
            }
        }
    }

    public void selectRoomFromDatabase() {
        if (selectedRoomNumber == null || selectedRoomNumber.equals("")) {
            return;
        }

        Room example = new Room();
        example.setNumber(selectedRoomNumber);

        Optional<Room> roomOptinal = roomRepository.findOne(Example.of(example));
        if (roomOptinal.isPresent()) {
            selectedRoom = roomOptinal.get();
        }
    }

    private String createRoomTitle(Room room) {
        String prefix = " (" + room.getRoomType().toString().substring(0, 1) + ")";
        if (room.isBusy()) {
            prefix += " проживает " + room.getGuestsCount() + " гостей";
        } else {
            prefix += " свободна - " + room.getTotalNumberOfSeats() + " мест";
        }

        return room.getNumber() + prefix;
    }

    public Date getCleaningDate() {
        return cleaningDate;
    }

    public void setCleaningDate(Date cleaningDate) {
        this.cleaningDate = cleaningDate;
    }

    public void sendSms() {
        String ACCOUNT_SID = "AC5063e9d84a39c51465a997ad37bcdc9a";
        String AUTH_TOKEN = "75f1e5dc14555fbba8dca62da0fb6875";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            Message message = Message.creator(
                    new PhoneNumber("+380636548313"),
                    new PhoneNumber("+18087934933"), "Прошу вас убрать комнату 10го числа").create();
            System.out.println(message.getSid());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Смс было отправлено", null));
    }

    public String getSelectedRoomNumber() {
        return selectedRoomNumber;
    }

    public void setSelectedRoomNumber(String selectedRoomNumber) {
        this.selectedRoomNumber = selectedRoomNumber;
    }

    public Room getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

    public StageRepository getStageRepository() {
        return stageRepository;
    }

    public void setStageRepository(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public DefaultMenuModel getMenu() {
        return menu;
    }

    public void setMenu(DefaultMenuModel menu) {
        this.menu = menu;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

