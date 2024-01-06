package Generics.JavaGenericsOldExample.MultipleBoundedClassJavaGenerics;

public class Dog extends Animal implements Interface1, Interface2{
    @Override
    public String myAnimalName() {
        interface1Func();
        interface2Func();
        return "I am Dog...Geu Geu";
    }

    @Override
    public void interface1Func() {
        System.out.println("Dog has implemented Interface1");
    }

    @Override
    public void interface2Func() {
        System.out.println("Dog has implemented Interface2");
    }
}
