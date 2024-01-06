package Generics.JavaGenericsOldExample.BoundedGenerics;

import Generics.JavaGenericsOldExample.BoundedGenerics.animal.Animal;

//********** as Java Generic ta ANIMAL type ke Extend kore... so, Animal & Animal er SubClass ei khali instantiate korte parbo**********
public class Printer <T extends Animal> {
    T thingToPrint;

    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print_func(){
//        as `thingToPrint` is a Type of ANIMAL we can also access the variables & methods of the `Animal` Class
        System.out.println(thingToPrint.myAnimalName());
    }
}
