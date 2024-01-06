package DesignPattern.ObserverPattern;

public class Forecast implements Observer{

    @Override
    public void update() {
        System.out.println("Forecast");
    }
    
}
