package models;

import models.constants.GateStatus;
import models.constants.GateType;

public class Gate extends BaseModel{
    private String number;
    private String operator;
    private GateType gameType;
    private int floorNumber;
    private int parkingLotId;
    private GateStatus gameStatus;
    private int gateNumber;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public GateType getGameType() {
        return gameType;
    }

    public void setGameType(GateType gameType) {
        this.gameType = gameType;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

       public GateStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GateStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}