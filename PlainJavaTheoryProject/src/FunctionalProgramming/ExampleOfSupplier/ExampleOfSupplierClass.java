package FunctionalProgramming.ExampleOfSupplier;

import FunctionalProgramming.model.Person;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Supplier;

public class ExampleOfSupplierClass {

//TODO:
// Supplier --> takes Noting and Provide Something
    /*
        Supplier --> Supplier Input Parameter is NULL, A supplier supplies Returns value Only
        - it gives us something
        - The benefit is that something that is costly to produce but only needed in some
        - situations(Validation) can be passed as Supplier and then Only evaluated if need
     */

    public static void createEmployee(Person personObj, Supplier<String> errorMsgSupplier) {
    //  Employee Object Create korte ekta Person er MUST MUST "email" input dite hobe naile Create hobe Nah, eijonno CUSTOM Validation korar jonno nicher Function

        if (personObj.getEmail() == null || Objects.equals(personObj.getEmail(), "")){
            System.out.println(errorMsgSupplier.get());
        }

    //  validation sesh, then we can call Create Employee Method
    //  call createEmployeeAccount() function

    }

    // now let's Call this Method from main method
    public static void main(String[] args) {
        Person personObj = new Person("Sergio Ramos", "");

        //Supplier takes ZERO Input, it ONLY RETURNS Value
        createEmployee(personObj, () -> {
            String str = "Invalid Person, at " + LocalDateTime.now();
            return str;
        });

        createEmployee(personObj, () -> "Email Not Provided for Person, at " + LocalDateTime.now());
    }

}
