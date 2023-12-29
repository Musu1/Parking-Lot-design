package service.strategy.slotAllocationStrategy;

import exception.NoEmptyParkingSlotAvailableException;
import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.ParkingSlotStatus;
import models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy{
    @Override
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) throws NoEmptyParkingSlotAvailableException {
        int floor = entryGate.getFloorNumber();

        for(ParkingSlot slot : parkingLot.getParkingFloors().get(floor).getParkingSlots()){
            if( slot.getSupportedVehicleType().equals(vehicleType) && slot.getParkingSlotStatus() == ParkingSlotStatus.AVAILABLE){
                return slot;
            }
        }

        int i = floor-1;
        int j = floor+1;

        while(i>=0 || j<=parkingLot.getParkingFloors().size()){

            if(i>=0){
                for(ParkingSlot slot : parkingLot.getParkingFloors().get(i).getParkingSlots()){
                    if( slot.getSupportedVehicleType().equals(vehicleType) && slot.getParkingSlotStatus() == ParkingSlotStatus.AVAILABLE){
                        return slot;
                    }
                }
            }

            if(j<=parkingLot.getParkingFloors().size()){
                for(ParkingSlot slot : parkingLot.getParkingFloors().get(j).getParkingSlots()){
                    if( slot.getSupportedVehicleType().equals(vehicleType) && slot.getParkingSlotStatus() == ParkingSlotStatus.AVAILABLE){
                        return slot;
                    }
                }
            }
            i--;
            j++;
        }

        throw new NoEmptyParkingSlotAvailableException("No parking slots available");
    }
}
