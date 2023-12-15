package Generics.methodGenerics;

import Generics.methodGenerics.liquids.Juice;
import Generics.methodGenerics.liquids.Water;

public class Main {
    public static void main(String[] args) {
        Bartender bartender = new Bartender();
        Juice juice = new Juice();
        Water water = new Water();

        Cocktail cocktail = bartender.<Juice, Water>mix(juice, water);
        Cocktail cocktailStatic = Bartender.<Juice, Water>mix2static(juice, water);
    }
}
