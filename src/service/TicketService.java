package service;

import exception.GateNotFoundException;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundException;
import models.Ticket;
import models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket createTicket(Vehicle vehicle,int ticketId, int gateId, int parkingLotId, LocalDateTime entryTime) throws GateNotFoundException, ParkingLotNotFoundException, NoEmptyParkingSlotAvailableException;
}
