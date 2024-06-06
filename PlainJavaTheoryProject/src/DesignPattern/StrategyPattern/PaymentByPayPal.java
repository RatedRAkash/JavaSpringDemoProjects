package DesignPattern.StrategyPattern;

public class PaymentByPayPal implements PaymentStrategy{
    @Override
    public void collectPaymentDetails() {
        System.out.printf("using PayPal for payment");
    }

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.printf(String.format("Paying %s using PayPal for payment", amount));
    }
}
