package LambdaExpression.FunctionalProgramming.ExampleOfConsumer;

import LambdaExpression.FunctionalProgramming.model.Person;

import java.util.function.Consumer;

public class ExampleOfConsumerClass {

//TODO:
// Consumer --> take Input and Do Something with it and Returns Nothing

    /*
        Consumer --> usually Different way te Log Print korar jonno Use kora jete pare
        it returns NOTHING
        Example:
            - 1st Log ee "in Details(Name+Email)" soho Print korbo
            - 2nd Log ee Just (Name) Print korbo
     */

    public static void staticLogEmployeeMethod(Person personObj, Consumer<Person> logger) {
        logger.accept(personObj); // je ei Function Call korar somoy Consumer er Method Definiton likbe... shei Definition tai Trigger hobe ".accept()" Class er maddhome
    }

    // now let's Call this Method from main method
    public static void main(String[] args) {
        Person personObj = new Person("Sergio Ramos","ramos@gmail.com");

        // - 1st Log ee "in Details(Name+Email)" soho Print korbo
        staticLogEmployeeMethod(personObj, (Person per)->{
            System.out.print("Details Log ---> ");
            System.out.println("name: "+per.getName()+", email: "+per.getEmail());
        });


        // - 2nd Log ee Just (Name) Print korbo
        staticLogEmployeeMethod(personObj, (Person per)->{
            System.out.print("Shortcut Log ---> ");
            System.out.println("name: "+per.getName());
        });
    }

}
