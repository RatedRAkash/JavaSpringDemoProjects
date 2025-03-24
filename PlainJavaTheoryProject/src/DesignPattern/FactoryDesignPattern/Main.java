package DesignPattern.FactoryDesignPattern;

import DesignPattern.FactoryDesignPattern.factory.BurgerFactory;
import DesignPattern.FactoryDesignPattern.factory.Factory;
import DesignPattern.FactoryDesignPattern.factory.PizzaFactory;

public class Main { // this Main Function is the Client Code
    public static void main(String[] args) {
//        Application app = new Application(new PizzaFactory());
        Application app = new Application(new BurgerFactory()); // we can Change the "Factory" in Runtime & we will get Food according to that "Factory"
        app.getFood();
    }
}
