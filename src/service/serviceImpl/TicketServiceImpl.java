package service.serviceImpl;

import exception.GateNotFoundException;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundException;
import models.*;
import models.constants.TicketStatus;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import service.TicketService;

import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService {

    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private GateRepository gateRepository;

    public TicketServiceImpl(ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
    }

    @Override
    public Ticket createTicket(Vehicle vehicle,int ticketId, int gateId, int parkingLotId, LocalDateTime entryTime) throws GateNotFoundException, ParkingLotNotFoundException, NoEmptyParkingSlotAvailableException {
        Gate gate = gateRepository.get(gateId);
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);
        ParkingSlot parkingSlot = parkingLot.getSlotAllocationStrategy().findParkingSlot(vehicle.getVehicleType(),parkingLot,gate);
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(entryTime);
        ticket.setParkingSlot(parkingSlot);
        ticket.setGate(gate);
        ticket.setTicketStatus(TicketStatus.ACTIVE);
        ticket.setId(ticketId);
        return ticketRepository.put(ticket);
    }
}
