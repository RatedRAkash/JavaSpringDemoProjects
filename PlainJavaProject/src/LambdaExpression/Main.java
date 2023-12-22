package LambdaExpression;

public class Main {
    public static void main(String[] args) {

        printSound(() -> "Akash");

        //TODO RULE-1: eivabe Functional Interface key New Keyword diye Implement kore Argument hisave implement kora jay
        printYourParams(new CustomFunctionalInterface() {
            @Override
            public String appendRamosInParameter(String str) {
                return "Ramos "+str;
            }
        });


        //TODO RULE-2: eivabe Direct Lambda Expression er madhome oo kora jay, ekadik Parameter huile "Comma(,)" diye diye likbo
        printYourParams((str) ->"Ramos "+str);
        printYourParams(str ->"Ramos "+str);
        printYourParams(str -> {
            return "Ramos "+str;
        });

    }

    public static void printSound(Animal animal){
        System.out.println(animal.makeSound());
    }

    public static void printYourParams(CustomFunctionalInterface interfaceObj){
        System.out.println(interfaceObj.appendRamosInParameter("Akash"));
    }
}
