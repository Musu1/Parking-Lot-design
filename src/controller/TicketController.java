package controller;

import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import exception.GateNotFoundException;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundException;
import models.Ticket;
import models.Vehicle;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import service.TicketService;
import service.serviceImpl.TicketServiceImpl;

import java.time.LocalDateTime;

public class TicketController {

    private TicketService ticketService;

    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.ticketService = new TicketServiceImpl(parkingLotRepository,ticketRepository,gateRepository);
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws NoEmptyParkingSlotAvailableException, ParkingLotNotFoundException, GateNotFoundException {
        Vehicle vehicle = new Vehicle(ticketRequestDTO.getNumber(),ticketRequestDTO.getColor(),ticketRequestDTO.getName(),ticketRequestDTO.getVehicleType());
        Ticket ticket = ticketService.createTicket(vehicle,ticketRequestDTO.getTicketId(),ticketRequestDTO.getGateId(),ticketRequestDTO.getParkingLotId(), LocalDateTime.now());

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();

        ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
        ticketResponseDTO.setParkingSlot(ticket.getParkingSlot().getNumber());
        ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getNumber());

        return ticketResponseDTO;
    }
}
