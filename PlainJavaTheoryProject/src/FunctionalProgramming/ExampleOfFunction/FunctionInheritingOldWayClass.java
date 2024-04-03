package FunctionalProgramming.ExampleOfFunction;

import FunctionalProgramming.model.Person;

import java.util.function.Function;

public class FunctionInheritingOldWayClass implements Function<Person, String> {
    @Override
    public String apply(Person person) {
        return person.getName().toUpperCase();
    }
}
