package DesignPattern.FactoryDesignPattern.food;

public class Pizza implements Food {
    @Override
    public void prepare() {
        System.out.println("Pizza prepare");
    }
}
