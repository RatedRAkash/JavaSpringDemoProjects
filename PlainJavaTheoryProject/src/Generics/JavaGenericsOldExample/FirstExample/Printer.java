package Generics.JavaGenericsOldExample.FirstExample;

public class Printer <T> {
    T thingToPrint;

    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print_func(){
        System.out.println(thingToPrint);
    }
}
