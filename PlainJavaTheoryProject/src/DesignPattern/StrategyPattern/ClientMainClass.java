package DesignPattern.StrategyPattern;

public class ClientMainClass {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        //using "Strategy" Pattern we can give our Strategy for Payment during "Runtime"
        paymentService.setStrategy(new PaymentByCreditCard());
        paymentService.processOrder();
    }
}
