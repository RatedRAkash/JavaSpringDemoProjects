package Generics.JavaGenericsOldExample.SeveralParametersJavaGeneric;

public class Main {
    public static void main(String[] args) {

        // Reason we USE generics because, Otherwise if we want to TYPECAST with OBJECT Type Variables... Then we can get RUNTIME Error
        Printer<Integer, String> printer1 = new Printer<>(23, "Normal String");
        printer1.print_thingToPrint();
        printer1.print_thingToEat();

        methodBasedGenericFunc("Akash", 13);
    }

    private static <T, K> void methodBasedGenericFunc(T thingToPrint, K thingToEat){
        System.out.println("From Method : thingToPrint ---> " + thingToPrint);
        System.out.println("From Method : thingToEat ---> " + thingToEat);
    }
}
