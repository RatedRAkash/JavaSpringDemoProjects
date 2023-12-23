package LambdaExpression.FunctionalProgramming.ExampleOfSupplier;

import LambdaExpression.FunctionalProgramming.model.Person;

import java.util.function.Supplier;

public class SupplierInheritingOldWayClass implements Supplier<Person> {
    @Override
    public Person get() {
        return null;
    }
}
