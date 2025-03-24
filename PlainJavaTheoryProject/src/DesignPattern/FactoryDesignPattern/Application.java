package DesignPattern.FactoryDesignPattern;

import DesignPattern.FactoryDesignPattern.factory.Factory;
import DesignPattern.FactoryDesignPattern.factory.PizzaFactory;
import DesignPattern.FactoryDesignPattern.food.Food;

public class Application {
    Factory factory;
    public Application(Factory factory) {
        this.factory = factory;
    }

    public void getFood() {
        Food food = this.factory.createFood();
        food.prepare();
    }
}
