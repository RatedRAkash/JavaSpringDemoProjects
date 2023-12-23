package Generics.MethodLevelGenericsExample.glasses;

public class Glass<T>{
    T liquid;

    public Glass() {

    }
    public Glass(T liquid) {
        this.liquid = liquid;
    }

    public void printLiquid(){
        System.out.println(liquid.toString());
    }
}
