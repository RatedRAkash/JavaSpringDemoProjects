package DesignPattern.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        Beverage espressoCoffee = new Caramel(new Sugar(new EspressoCoffee()));

        System.out.println(espressoCoffee.getDesc());
        System.out.println("Price: " + espressoCoffee.getPrice());
    }
}
