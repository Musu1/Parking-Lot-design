package exception;

public class ParkingFloorNotFoundException extends Exception {
    public ParkingFloorNotFoundException() {
        super();
    }

    public ParkingFloorNotFoundException(String message) {
        super(message);
    }
}
