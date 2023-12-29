package models;

import models.constants.VehicleType;

public class Vehicle extends BaseModel{
    private int number;
    private String color;
    private String name;
    private VehicleType vehicleType;

    public Vehicle(int number, String color, String name, VehicleType vehicleType) {
        this.number = number;
        this.color = color;
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
