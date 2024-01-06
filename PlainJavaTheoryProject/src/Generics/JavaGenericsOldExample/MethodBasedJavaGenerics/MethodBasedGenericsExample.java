package Generics.JavaGenericsOldExample.MethodBasedJavaGenerics;

public class MethodBasedGenericsExample {
    public static void main(String[] args) {

        methodBasedGenericFunc1("Akash");
        methodBasedGenericFunc1(55);
        methodBasedGenericFunc1(58.58);
    }

    //********** Generic ta `<T `Function` er `RETURN-TYPE`(here it is `void`) er `BEFORE` dite hobe****************`
// syntax ---> private static <GENERIC_T> String method1 (GENERIC_T thingToShout)
    private static <T> void methodBasedGenericFunc1(T thingToShout){
        System.out.println(thingToShout + "!!!!!!!");
    }

    //eikane RETURN_TYPE oo `Generic Type ta nijei mane... <T> nijei
//    ei Example bujhar subidhar jonno <GENERIC_T> = <T> use kora hoyeche
    private static <GENERIC_T> GENERIC_T methodBasedGenericFunc2(GENERIC_T thingToShout){
        System.out.println(thingToShout + "!!!!!!!");

        return thingToShout;
    }
}
