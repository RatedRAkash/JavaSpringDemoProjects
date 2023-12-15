package Generics.methodGenerics;

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
}
