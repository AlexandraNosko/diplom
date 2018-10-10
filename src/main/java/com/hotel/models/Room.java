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

    private String freeBerth;

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

    public String getFreeBerth() {
        return freeBerth;
    }

    public void setFreeBerth(String free) {
        this.freeBerth = free;
    }
}
