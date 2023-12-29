package service.strategy.billCalculationStrategy;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(BillCalculationStrategies billCalculationStrategies){
        return switch (billCalculationStrategies){
            case LowBillCalculationStrategy -> new LowBillCalculationStrategy();
        };
    }
}
