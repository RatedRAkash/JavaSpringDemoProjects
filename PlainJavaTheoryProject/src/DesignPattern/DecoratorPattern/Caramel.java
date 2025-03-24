package DesignPattern.DecoratorPattern;

public class Caramel extends AddOnDecorator {
    public Beverage beverage;

    Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDesc() {
        return this.beverage.getDesc() + " + Caramel";
    }

    @Override
    public int getPrice() {
        return this.beverage.getPrice() + 3;
    }
}
