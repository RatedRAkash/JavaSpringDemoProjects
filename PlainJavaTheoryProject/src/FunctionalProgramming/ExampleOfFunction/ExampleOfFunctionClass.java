package FunctionalProgramming.ExampleOfFunction;

import FunctionalProgramming.model.Employee;
import FunctionalProgramming.model.Person;

import java.util.function.Function;

public class ExampleOfFunctionClass {

//TODO:
// FunctionalProgramming --> Functions are Treated as FIRST CLASS CITIZENS, jekeono METHOD er moddhe amra Function ke PARAMETER hisave dite parbo(Python/JavaScript er moto)

    /*
        FUNCTION --> map x to y
        Allow us to convert one thing to another
        Example:
            - Say we have a HR System
            - We want to allow Different Companies using our HR System software to be able to specify how they generate an employee ID(some wants ID to be Extracted from Person' Email, others want from Person's Name)
            - We can use a function for that so that Different Companies can generate EmployeeID Differently
     */

    public static Employee generateEmployeeId(Person personObj, Function<Person, String> mapToIdFunction) {
        Employee employeeObj = new Employee();

        // jey generateEmployeeId() ei function ke call dibe shey "Function" er moddhe bolbe jey kivabe Person object theke String ee Conversion korbe
        employeeObj.setId(mapToIdFunction.apply(personObj)); //TODO: mapToIdFunction er jei Implementation Provide kora hobe... sheitar Code Trigger korbe

        return employeeObj;
    }

    // now let's Call this Method from main method
    public static void main(String[] args) {
        Person personObj = new Person("Sergio Ramos", "ramos@gmail.com");

        //TODO: Function<Person, String> mapToId  ---> so, ekta Person Object pass korbo and Return korbo ekta String, shei String ta Automatic giye EmployeeId te giye save hobe


        // Company1 want all UPPERCASE for EmployeeID
        Employee employeeObj1 = generateEmployeeId(personObj, (Person per) -> {  //Parameter er TYPE "Person" Nah dileo hui(nicher Example)
            return per.getName().toUpperCase();
        });


        // Company2 want all EMAIL+@RMA for EmployeeID
        Employee employeeObj2 = generateEmployeeId(personObj, (per) -> {
            return per.getEmail()+"@RMA";
        });

        // Company3 want all "RMA."+NAME for EmployeeID
        Employee employeeObj3 = generateEmployeeId(personObj, (per) -> "RMA." + per.getEmail());

        System.out.println(employeeObj1.getId());
        System.out.println(employeeObj2.getId());
        System.out.println(employeeObj3.getId());

    }

}
