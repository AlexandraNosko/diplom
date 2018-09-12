package com.example.demo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CarPage {

    @Inject
    private CarRepository carRepository;

    private String model;
    private String year;
    private String engine;
    private String wheels;
    private String color;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void saveCar() {
        Car car = new Car();
        car.setModel(model);
        car.setYear(year);
        car.setEngine(engine);
        car.setWheels(wheels);
        car.setColor(color);
        carRepository.save(car);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }
}
