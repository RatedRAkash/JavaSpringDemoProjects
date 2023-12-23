package Generics.MethodLevelGenericsExample;

import Generics.MethodLevelGenericsExample.glasses.Glass;
import Generics.MethodLevelGenericsExample.glasses.WineGlass;
import Generics.MethodLevelGenericsExample.liquids.Juice;
import Generics.MethodLevelGenericsExample.liquids.OrangeJuice;
import Generics.MethodLevelGenericsExample.liquids.Water;

public class Main {
    public static void main(String[] args) {
        Bartender bartender = new Bartender();
        Juice juice = new Juice();
        Water water = new Water();

        Cocktail cocktail = bartender.<Juice, Water>mix(juice, water);
        Cocktail cocktailStatic = Bartender.<Juice, Water>mix2static(juice, water);

        //TODO: This is Not Allowed... Wildcards (?) Try to Solve this issue
        // Glass<Juice> juiceGlass != new Glass<OrangeJuice>();
        // instead we use Glass<?> as Method argument, so that any Glass<Juice>, Glass<Water>, Glass<OrangeJuice> etc.. can be passed when Calling the Method

        // TODO: This is Allowed
        Glass<Juice> glass = new WineGlass<Juice>();

        Cocktail cocktailStaticWildcard = Bartender.mix3static(new Glass<Juice>(new Juice()));
    }
}
