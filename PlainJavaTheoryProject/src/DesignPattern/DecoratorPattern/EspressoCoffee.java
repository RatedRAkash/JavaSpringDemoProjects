package DesignPattern.DecoratorPattern;

public class EspressoCoffee implements Beverage {
    @Override
    public String getDesc() {
        return "Espresso";
    }

    @Override
    public int getPrice() {
        return 12;
    }
}
