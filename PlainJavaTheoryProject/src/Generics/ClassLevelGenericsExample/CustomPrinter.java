package Generics.ClassLevelGenericsExample;

import Generics.ClassLevelGenericsExample.animals.Animal;

public class CustomPrinter <T extends Animal>{
    T thingToPrint;

    public CustomPrinter(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void printStatement(){
        System.out.println(thingToPrint.sayYourName());
    }
}
