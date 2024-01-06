package Generics.JavaGenericsOldExample.FirstExample;

public class Main {
    public static void main(String[] args) {

        // Reason we USE generics because, Otherwise if we want to TYPECAST with OBJECT Type Variables... Then we can get RUNTIME Error
        Printer<Integer> printer1 = new Printer<>(23);
        printer1.print_func();

        Printer<Double> printer2 = new Printer<>(55.58);
        printer2.print_func();
    }
}
