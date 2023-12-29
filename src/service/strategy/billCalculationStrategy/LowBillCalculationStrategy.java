package service.strategy.billCalculationStrategy;

import models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy {
    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;

    private static final double INCREMENT_CHARGES = 0.5;

    /*
    * Base amount = PER_HOUR_CHARGE_2_WHEELER * hour
    * Total amount = Base amount + Base Amount * (INCREMENT_CHARGES * (hour-1))
    * */
    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime) {
        LocalDateTime entryTime = ticket.getEntryTime();
        long totalHours = ChronoUnit.HOURS.between(entryTime,exitTime);
        long baseAmount = switch (ticket.getVehicle().getVehicleType()){
            case CAR, BUS -> totalHours * PER_HOUR_CHARGE_4_WHEELER;
            case BIKE -> totalHours * PER_HOUR_CHARGE_2_WHEELER;
            case TRUCK -> 0;
        };
        double totalAmount = baseAmount + baseAmount * (INCREMENT_CHARGES * (totalHours-1));
        return totalAmount;
    }
}
