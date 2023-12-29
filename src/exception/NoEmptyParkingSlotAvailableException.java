package exception;

public class NoEmptyParkingSlotAvailableException extends Throwable {
    public NoEmptyParkingSlotAvailableException() {
        super();
    }

    public NoEmptyParkingSlotAvailableException(String message) {
        super(message);
    }
}
