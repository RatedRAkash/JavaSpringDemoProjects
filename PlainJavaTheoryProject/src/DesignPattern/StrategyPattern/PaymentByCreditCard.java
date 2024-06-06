package DesignPattern.StrategyPattern;

public class PaymentByCreditCard implements PaymentStrategy{

    private int extraCostForCreditCard=10;

    @Override
    public void collectPaymentDetails() {
        System.out.printf("using CreditCard for payment");
    }

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.printf(String.format("Paying %s using CreditCard for payment", amount));
    }
}
