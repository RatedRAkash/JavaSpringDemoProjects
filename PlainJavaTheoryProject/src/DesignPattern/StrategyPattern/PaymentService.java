package DesignPattern.StrategyPattern;

public class PaymentService {
    private int cost;
    private boolean includeDelivery;

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processOrder(){
        strategy.collectPaymentDetails();
        if(strategy.validatePaymentDetails()){
            strategy.pay(cost);
        }
    }
}
