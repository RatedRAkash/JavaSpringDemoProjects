package DesignPattern.DecoratorPattern;

public class Sugar extends AddOnDecorator {
    public Beverage beverage;

    Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDesc() {
        return this.beverage.getDesc() + " + Sugar";
    }

    @Override
    public int getPrice() {
        return this.beverage.getPrice() + 1;
    }
}
