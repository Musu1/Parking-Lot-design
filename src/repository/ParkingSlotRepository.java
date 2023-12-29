package repository;

import exception.ParkingSlotNotFoundException;
import exception.TicketNotFoundException;
import models.ParkingSlot;
import models.Ticket;

import java.util.HashMap;

public class ParkingSlotRepository {
    HashMap<Integer, ParkingSlot> parkingSlotHashMap;

    public ParkingSlotRepository() {
        this.parkingSlotHashMap = new HashMap<>();
    }

    public ParkingSlot get(int parkingSlotId) throws ParkingSlotNotFoundException {
        ParkingSlot parkingSlot = parkingSlotHashMap.get(parkingSlotId);
        if(parkingSlot == null){
            throw new ParkingSlotNotFoundException("Ticket id not found , id = "+parkingSlotId);
        }
        return parkingSlot;
    }

    public ParkingSlot put(ParkingSlot parkingSlot){
        parkingSlotHashMap.put(parkingSlot.getId(),parkingSlot);
        return parkingSlot;
    }
}
