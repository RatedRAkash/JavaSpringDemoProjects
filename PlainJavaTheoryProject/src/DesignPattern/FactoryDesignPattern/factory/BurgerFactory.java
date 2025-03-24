package DesignPattern.FactoryDesignPattern.factory;

import DesignPattern.FactoryDesignPattern.food.Burger;
import DesignPattern.FactoryDesignPattern.food.Food;

public class BurgerFactory implements Factory {
    @Override
    public Food createFood() {
        return new Burger();
    }
}