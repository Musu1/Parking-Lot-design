package repository;

import exception.TicketNotFoundException;
import models.Ticket;

import java.util.HashMap;

public class TicketRepository {

    HashMap<Integer, Ticket> ticketHashMap;

    public TicketRepository() {
        this.ticketHashMap = new HashMap<>();
    }

    public Ticket get(int ticketId) throws TicketNotFoundException {
        Ticket ticket = ticketHashMap.get(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("Ticket id not found , id = "+ticketId);
        }
        return ticket;
    }

    public Ticket put(Ticket ticket){
            ticketHashMap.put(ticket.getId(),ticket);
            return ticket;
    }
}
