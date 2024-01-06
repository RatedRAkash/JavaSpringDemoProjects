package Generics.JavaGenericsOldExample.SeveralParametersJavaGeneric;

public class Printer <T, K> {
    T thingToPrint;
    K thingToEat;

    public Printer(T thingToPrint, K thingToEat){
        this.thingToPrint = thingToPrint;
        this.thingToEat = thingToEat;
    }

    public void print_thingToPrint(){
        System.out.println("Classbased : thingToPrint ---> " + thingToPrint);
    }
    public void print_thingToEat(){

        System.out.println("Classbased : thingToEat ---> " + thingToEat);
    }
}
