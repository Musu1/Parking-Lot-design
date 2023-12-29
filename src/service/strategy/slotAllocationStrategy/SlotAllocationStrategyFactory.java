package service.strategy.slotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategy(SlotAllocationStrategies slotAllocationStrategies){
        return switch (slotAllocationStrategies){
            case NEAREST_SLOT_ALLOCATION_STRATEGY -> new NearestSlotAllocationStrategy();
        };
    }
}
