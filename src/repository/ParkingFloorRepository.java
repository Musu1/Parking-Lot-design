package repository;

import exception.ParkingFloorNotFoundException;
import exception.TicketNotFoundException;
import models.ParkingFloor;
import models.Ticket;

import java.util.HashMap;

public class ParkingFloorRepository {
    HashMap<Integer, ParkingFloor> parkingFloorHashMap;

    public ParkingFloorRepository() {
        this.parkingFloorHashMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorId) throws ParkingFloorNotFoundException {
        ParkingFloor parkingFloor = parkingFloorHashMap.get(parkingFloorId);
        if(parkingFloor == null){
            throw new ParkingFloorNotFoundException("Parking Floor id not found , id = "+parkingFloorId);
        }
        return parkingFloor;
    }

    public ParkingFloor put(ParkingFloor parkingFloor){
        parkingFloorHashMap.put(parkingFloor.getId(),parkingFloor);
        return parkingFloor;
    }
}
