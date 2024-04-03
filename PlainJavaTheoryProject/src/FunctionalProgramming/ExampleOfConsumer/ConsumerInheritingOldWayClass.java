package FunctionalProgramming.ExampleOfConsumer;

import FunctionalProgramming.model.Person;

import java.util.function.Consumer;

public class ConsumerInheritingOldWayClass implements Consumer<Person> {
    //TODO: eikane sudhu Person er Name Log ee Print kora hui... Jodi extra kisu korte chai taile arekta Class khule sheikane abr Same Method Override kore Same jinish kora lagbe... eijonno eivabe Inherit kore kaaj kora GOOD-WAY Nah

    @Override
    public void accept(Person Person) {
        System.out.println("Printing Person Log for name: "+ Person.getName());
    }
}