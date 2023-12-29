package repository;

import exception.ParkingLotNotFoundException;
import exception.TicketNotFoundException;
import models.ParkingLot;
import models.ParkingSlot;
import models.Ticket;

import java.util.HashMap;

public class ParkingLotRepository {
    HashMap<Integer, ParkingLot> parkingLotHashMap;

    public ParkingLotRepository() {
        this.parkingLotHashMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId) throws ParkingLotNotFoundException {
        ParkingLot parkingLot = parkingLotHashMap.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("Parking Lot id not found , id = "+parkingLotId);
        }
        return parkingLot;
    }

    public ParkingLot put(ParkingLot parkingLot){
        parkingLotHashMap.put(parkingLot.getId(),parkingLot);
        return parkingLot;
    }
}
