package com.hotel.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private Integer cost;

    private RoomType roomType;

    @ManyToOne
    private Stage stage;

    private Integer guestsCount;

    private Date arrivalDate;

    private Date departureDate;

    private Integer totalNumberOfSeats;

    private Integer paid;

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
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

    public Integer getGuestsCount() {
        return guestsCount;
    }

    public Integer getDaysLeftToDearture() {
        if (departureDate == null) {
            return 0;
        }

        int daysdiff = 0;
        long diff = departureDate.getTime() - new Date().getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        daysdiff = (int) diffDays;
        return daysdiff;
    }

    public Integer getMoneyLeftToPaid() {
        if (cost != null && paid != null) {
            return cost - paid;
        } else {
            return 0;
        }
    }

    public boolean isBusy() {
        return arrivalDate != null && departureDate != null;
    }
    public Integer getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(Integer totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public void setGuestsCount(Integer guestsCount) {
        this.guestsCount = guestsCount;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
