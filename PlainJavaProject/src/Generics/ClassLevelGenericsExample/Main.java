package Generics.ClassLevelGenericsExample;

import Generics.ClassLevelGenericsExample.animals.Dog;
import Generics.ClassLevelGenericsExample.animals.Lion;

public class Main {
    public static void main(String[] args) {
        CustomPrinter<Dog> d = new CustomPrinter<>(new Dog());
        CustomPrinter<Lion> l = new CustomPrinter<>(new Lion());

        d.printStatement();
        l.printStatement();
    }
}