package DesignPattern.StrategyPattern;

public interface PaymentStrategy {
    void collectPaymentDetails();
    boolean validatePaymentDetails();
    void pay(int amount);
}
