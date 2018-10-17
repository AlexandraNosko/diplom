package com.hotel.pages;

import com.hotel.models.Room;
import com.hotel.repositories.RoomRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@ViewScoped
public class ReserveRoomPage {

    @Inject
    private RoomRepository roomRepository;

    @Inject
    private MenuPage menuPage;

    private Date arrivalDate;

    private Date departureDate;

    private Integer guests;

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public String reserveRoom() {
        Room room = menuPage.getSelectedRoom();
        room.setArrivalDate(arrivalDate);
        room.setDepartureDate(departureDate);
        room.setGuestsCount(guests);
        roomRepository.save(room);

        return "goToMenu";
    }
}
