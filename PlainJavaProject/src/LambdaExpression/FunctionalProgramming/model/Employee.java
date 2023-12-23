package LambdaExpression.FunctionalProgramming.model;

public class Employee {

//    here ID is a String as it can have both Number+Characters
    private String id;

    public Employee() {
    }

    public Employee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
