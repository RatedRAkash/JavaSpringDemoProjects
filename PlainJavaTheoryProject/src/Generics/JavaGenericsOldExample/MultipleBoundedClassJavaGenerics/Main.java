package Generics.JavaGenericsOldExample.MultipleBoundedClassJavaGenerics;

public class Main {
    public static void main(String[] args) {

//********** as Java Generic ta ANIMAL type ke Extend kore... so, Animal & Animal er SubClass ei khali instantiate korte parbo**********
//        Printer<Integer> printer1 = new Printer<>(23);
//        printer1.print_func();

        Printer<Dog> printer2 = new Printer<>(new Dog());
        printer2.print_func();

//        here `Cat`- class has only Extended `Animal`- Class But NOT `Interface1` `Interface2`... So it can not be instantiated, So ERROR dibe
//        Printer<Cat> printer3 = new Printer<>(new Cat());
//        printer3.print_func();
    }
}
