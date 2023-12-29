import controller.BillController;
import controller.TicketController;
import dto.BillRequestDTO;
import dto.BillResponseDTO;
import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import exception.GateNotFoundException;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundException;
import exception.TicketNotFoundException;
import models.constants.VehicleType;
import repository.*;
import service.InitService;
import service.serviceImpl.InitServiceImpl;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws NoEmptyParkingSlotAvailableException, ParkingLotNotFoundException, GateNotFoundException, TicketNotFoundException {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
        initService.init();

        TicketController ticketController = new TicketController(parkingLotRepository,gateRepository,ticketRepository);
        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setName("Mercedes");
        ticketRequestDTO.setColor("Red");
        ticketRequestDTO.setNumber(12345);
        ticketRequestDTO.setTicketId(1);

        TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);

        BillController billController = new BillController(parkingLotRepository,ticketRepository);
        BillRequestDTO billRequestDTO = new BillRequestDTO();
        billRequestDTO.setExitTime(LocalDateTime.of(2023, Month.OCTOBER,25,12,0,0));
        billRequestDTO.setTicketId(1);

        BillResponseDTO billResponseDTO = billController.generateBill(billRequestDTO);
        System.out.println(billResponseDTO);
    }
}