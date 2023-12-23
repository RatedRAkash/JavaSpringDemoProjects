package Generics.MethodLevelGenericsExample;

import Generics.MethodLevelGenericsExample.glasses.Glass;
import Generics.MethodLevelGenericsExample.liquids.Liquid;

public class Cocktail {

    public Cocktail() {

    }
    public Cocktail(Glass<? extends Liquid> glass) {
        glass.printLiquid();
    }
}
