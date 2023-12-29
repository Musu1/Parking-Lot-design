package dto;

import java.time.LocalDateTime;

public class TicketResponseDTO {
    private String entryTime;
    private int parkingSlot;
    private int vehicleNumber;

    @Override
    public String toString() {
        return "TicketResponseDTO{" +
                "entryTime='" + entryTime + '\'' +
                ", parkingSlot=" + parkingSlot +
                ", vehicleNumber=" + vehicleNumber +
                '}';
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
