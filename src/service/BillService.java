package service;

import exception.ParkingLotNotFoundException;
import models.Bill;
import models.Ticket;

import java.time.LocalDateTime;

public interface BillService {
    Bill generateBill(Ticket ticket, LocalDateTime exitTime) throws ParkingLotNotFoundException;
}
