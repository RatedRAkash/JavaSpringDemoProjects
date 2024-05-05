package DesignPattern.CompositePattern;

public class Main {

    public static void main(String[] args) {
        Composite box = new Composite();
        box.add(new Leaf1());
        box.add(new Leaf2());

        System.out.printf("Price: " + box.getPrice());
    }
}
