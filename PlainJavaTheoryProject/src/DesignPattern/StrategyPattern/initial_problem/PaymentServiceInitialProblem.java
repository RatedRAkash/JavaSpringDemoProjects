package DesignPattern.StrategyPattern.initial_problem;

public class PaymentServiceInitialProblem {

    private int cost;
    private boolean includeDelivery;

    public void processOrder(String paymentMethod){
        //Problem arises as we have to do so much "if/else" Block for each condition
        if(paymentMethod.equals("CreditCard")){
            System.out.printf("using CreditCard for payment");
        }
        else if(paymentMethod.equals("PayPal")){
            System.out.printf("using PayPal for payment");
        }
    }
}
