package Generics.JavaGenericsOldExample.WildCardJavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class WildCardJavaGenericMain {
    public static void main(String[] args) {

        List<Integer> myIntList = new ArrayList<>();
//        printList(myIntList); // reason ---> List<Integer> != List<Object> jodio Integer = Object(inheritancec er jonno)
        myGenericPrintList(myIntList);



        //only ANIMAL Type er List ei Nibe Parameter hisave
        List<Dog> myDogList = new ArrayList<>();
        myGenericExtendsAnimalPrintList(myDogList);

    }

//   eikane Bujhte hobe jey... jodio Integer = Object (jehetu Integer class Extends Object Class)
//   but but but ---> List<Integer> != List<Object> ... tik ei karone amra `printList` use korte parbo Nah
//   amader "myGenericPrintList" use korte hobe with WILDCARD --->  <?>
    private static void printList(List<Object> myList){
        System.out.println(myList);
    }

    private static void myGenericPrintList(List<?> myList){
        System.out.println(myList);
    }

    private static void myGenericExtendsAnimalPrintList(List<? extends Animal> myList){
        System.out.println(myList);
    }
}
