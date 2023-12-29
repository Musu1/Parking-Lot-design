package service.serviceImpl;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import service.InitService;
import service.strategy.billCalculationStrategy.BillCalculationStrategies;
import service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;
import service.strategy.slotAllocationStrategy.SlotAllocationStrategies;
import service.strategy.slotAllocationStrategy.SlotAllocationStrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitServiceImpl implements InitService {
    private ParkingSlotRepository parkingSlotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;

    public InitServiceImpl(ParkingSlotRepository parkingSlotRepository, ParkingFloorRepository parkingFloorRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
    }
    @Override
    public void init() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("Street A, City B, State C");
        parkingLot.setBillCalculationStrategy(BillCalculationStrategyFactory.getBillCalculationStrategy(BillCalculationStrategies.LowBillCalculationStrategy));
        parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.getSlotAllocationStrategy(SlotAllocationStrategies.NEAREST_SLOT_ALLOCATION_STRATEGY));
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setVehicleTypes(new ArrayList<>(Arrays.asList(VehicleType.BIKE,VehicleType.CAR)));
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i = 0;i<10;i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for(int j = 1;j<=10;j++){
                VehicleType supportedType = j % 2 != 0 ?
                        VehicleType.BIKE : VehicleType.CAR;
                ParkingSlot parkingSlot = new ParkingSlot(i*100+j,i*100,supportedType,ParkingSlotStatus.AVAILABLE);
                parkingSlots.add(parkingSlot);
                parkingSlotRepository.put(parkingSlot);
            }
            parkingFloor.setParkingSlots(parkingSlots);

            Gate entryGate = new Gate();
            entryGate.setId(i*10+1);
            entryGate.setGateNumber(i*10+1);
            entryGate.setGameStatus(GateStatus.OPEN);
            entryGate.setGameType(GateType.ENTRY);
            entryGate.setOperator("Muskan");
            entryGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);
            gateRepository.put(entryGate);

            Gate exitGate = new Gate();
            exitGate.setId(i * 10 + 2);
            exitGate.setGateNumber(i * 10 + 2);
            exitGate.setGameStatus(GateStatus.OPEN);
            exitGate.setGameType(GateType.EXIT);
            exitGate.setOperator("Ram");
            exitGate.setParkingLotId(1);
            exitGate.setFloorNumber(i);
            gateRepository.put(exitGate);

            List<Gate> gates = new ArrayList<>(Arrays.asList(entryGate,exitGate));
            parkingFloor.setGates(gates);
            parkingFloorRepository.put(parkingFloor);
            parkingFloors.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);

    }
}
