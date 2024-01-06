package Generics.JavaGenericsOldExample.MultipleBoundedClassJavaGenerics;

//              syntax --->  <T extends `ClassName` & `Interface1` & `Interface2`>
// we can not Add More Than 1 Class in Bounded Parameters...we can Add more than One Interface in Bounded Parameters
// also Order Has to be `CLASS-Name` first & then all the Interfaces Name
public class Printer <T extends Animal & Interface1 & Interface2> { //`Serializable` is also an `interface`
    T thingToPrint;

    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print_func(){
//        as `thingToPrint` is a Type of ANIMAL we can also access the variables & methods of the `Animal` Class
        System.out.println(thingToPrint.myAnimalName());
    }
}
