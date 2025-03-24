package DesignPattern.FactoryDesignPattern.factory;

import DesignPattern.FactoryDesignPattern.food.Food;
import DesignPattern.FactoryDesignPattern.food.Pizza;

public class PizzaFactory implements Factory {
    @Override
    public Food createFood() {
        return new Pizza();
    }
}
