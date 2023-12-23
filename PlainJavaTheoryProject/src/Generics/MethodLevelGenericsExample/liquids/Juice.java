package Generics.MethodLevelGenericsExample.liquids;

public class Juice implements Liquid{
    @Override
    public void echo_liquid_name() {
        System.out.println("Juice");
    }
}
