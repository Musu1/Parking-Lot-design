package exception;

public class TicketNotFoundException extends Throwable {
    public TicketNotFoundException() {
        super();
    }

    public TicketNotFoundException(String message) {
        super(message);
    }
}
