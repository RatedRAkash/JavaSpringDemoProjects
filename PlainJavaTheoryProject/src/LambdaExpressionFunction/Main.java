package LambdaExpressionFunction;

public class Main {
    public static void main(String[] args) {

        // TODO: *** Functions are Treated as FIRST CLASS CITIZENS, jekeono METHOD er moddhe amra Function ke PARAMETER hisave dite parbo(Python/JavaScript er moto)

        printSound(() -> "Akash");

        //TODO RULE-1: eivabe Functional Interface key New Keyword diye Implement kore Argument hisave implement kora jay
        printYourParams(new CustomFunctionalInterface() {
            @Override
            public String appendRamosInParameter(String str) {
                return "Ramos1 "+str;
            }
        });


        //TODO RULE-2: eivabe Direct Lambda Expression er madhome oo kora jay, ekadik Parameter huile "Comma(,)" diye diye likbo
        printYourParams((str) -> "Ramos2 "+str);
        printYourParams(str -> "Ramos3 "+str);
        printYourParams(str -> {
            return "Ramos4 "+str;
        });

    }

    public static void printSound(Animal animal){
        System.out.println(animal.makeSound());
    }

    public static void printYourParams(CustomFunctionalInterface interfaceObj){
        System.out.println(interfaceObj.appendRamosInParameter("Akash"));
    }
}
