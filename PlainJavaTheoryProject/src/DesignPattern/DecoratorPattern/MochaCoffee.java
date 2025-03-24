package DesignPattern.DecoratorPattern;

public class MochaCoffee implements Beverage {
    @Override
    public String getDesc() {
        return "Mocha Coffee";
    }

    @Override
    public int getPrice() {
        return 6;
    }
}
