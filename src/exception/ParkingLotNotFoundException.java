package exception;

public class ParkingLotNotFoundException extends Throwable {
    public ParkingLotNotFoundException() {
        super();
    }

    public ParkingLotNotFoundException(String message) {
        super(message);
    }
}
