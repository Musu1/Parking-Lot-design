package controller;

import dto.BillRequestDTO;
import dto.BillResponseDTO;
import exception.ParkingLotNotFoundException;
import exception.TicketNotFoundException;
import models.Bill;
import models.Ticket;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import service.BillService;
import service.serviceImpl.BillServiceImpl;

import java.time.temporal.ChronoUnit;

public class BillController {

    private BillService billService;
    private TicketRepository ticketRepository;

    public BillController(ParkingLotRepository parkingLotRepository,TicketRepository ticketRepository) {
        this.billService = new BillServiceImpl(parkingLotRepository);
        this.ticketRepository = ticketRepository;
    }

    public BillResponseDTO generateBill(BillRequestDTO billRequestDTO) throws TicketNotFoundException, ParkingLotNotFoundException {
        Ticket ticket = ticketRepository.get(billRequestDTO.getTicketId());
        Bill bill = billService.generateBill(ticket,billRequestDTO.getExitTime());

        BillResponseDTO billResponseDTO = new BillResponseDTO();
        billResponseDTO.setBillAmount(bill.getAmount());
        billResponseDTO.setParkingDuration(ChronoUnit.HOURS.between(ticket.getEntryTime(), bill.getExitTime()));
        billResponseDTO.setParkingSlot(ticket.getParkingSlot().getNumber());

        return billResponseDTO;
    }
}
