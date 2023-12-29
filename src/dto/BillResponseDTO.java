package dto;

public class BillResponseDTO {
    private long parkingDuration;
    private double billAmount;
    private int parkingSlot;

    @Override
    public String toString() {
        return "BillResponseDTO{" +
                "parkingDuration=" + parkingDuration +
                ", billAmount=" + billAmount +
                ", parkingSlot=" + parkingSlot +
                '}';
    }

    public long getParkingDuration() {
        return parkingDuration;
    }

    public void setParkingDuration(long parkingDuration) {
        this.parkingDuration = parkingDuration;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
