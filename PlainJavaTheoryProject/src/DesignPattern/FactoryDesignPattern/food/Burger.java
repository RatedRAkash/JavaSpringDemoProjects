package DesignPattern.FactoryDesignPattern.food;

public class Burger implements Food {
    @Override
    public void prepare() {
        System.out.println("Burger prepare");
    }
}
