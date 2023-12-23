package Generics.MethodLevelGenericsExample;

import Generics.MethodLevelGenericsExample.glasses.Glass;
import Generics.MethodLevelGenericsExample.liquids.Juice;
import Generics.MethodLevelGenericsExample.liquids.Liquid;

public class Bartender {

//    generics used in Methods

    //  Syntax is ---> <public> <Generics Type> <Return Type> <nameOfMethod> (...)
    public <J,W> Cocktail mix(J j, W w){
        return new Cocktail();
    }


    //  Syntax is ---> <public> <static> <Generics Type> <Return Type> <nameOfMethod> (...)
    public static <J,W> Cocktail mix2static(J j, W w){
        return new Cocktail();
    }


    //TODO: This is Not Allowed... Wildcards (?) Try to Solve this issue
    // Glass<Juice> juiceGlass != new Glass<OrangeJuice>();
    // instead we use Glass<?> as Method argument, so that any Glass<Juice>, Glass<Water>, Glass<OrangeJuice> etc.. can be passed when Calling the Method
    public static Cocktail mix3static(Glass<? extends Liquid> glass){
        return new Cocktail(glass);
    }
}
