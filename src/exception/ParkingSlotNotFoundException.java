package exception;

public class ParkingSlotNotFoundException extends Exception {
    public ParkingSlotNotFoundException() {
        super();
    }

    public ParkingSlotNotFoundException(String message) {
        super(message);
    }
}
