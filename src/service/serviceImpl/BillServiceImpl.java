package service.serviceImpl;

import exception.ParkingLotNotFoundException;
import models.Bill;
import models.ParkingLot;
import models.Ticket;
import repository.ParkingLotRepository;
import service.BillService;

import java.time.LocalDateTime;

public class BillServiceImpl implements BillService {

    private ParkingLotRepository parkingLotRepository;

    public BillServiceImpl(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public Bill generateBill(Ticket ticket, LocalDateTime exitTime) throws ParkingLotNotFoundException {
        int parkingLotId = ticket.getGate().getParkingLotId();
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);

        double amount = parkingLot.getBillCalculationStrategy().calculateBillAmount(ticket,exitTime);

        Bill bill = new Bill(exitTime,amount,ticket,ticket.getGate());
        return bill;
    }
}
