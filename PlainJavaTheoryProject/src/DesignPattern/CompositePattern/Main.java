package DesignPattern.CompositePattern;

public class Main {

    public static void main(String[] args) {
        // 1 ta BigBox er moddhe ekadik Leaf Nodes & 1 ta SmallBox oo rakhte parbo...
        // Because, BigBox, SmallBox & LeafNode all are ---> "Component" Class
        Composite bigBox = new Composite();
        bigBox.add(new Leaf1());
        bigBox.add(new Leaf2());

        Composite smallBox = new Composite();
        smallBox.add(new Leaf1());

        //smallBox raklam BigBox er moddhe
        bigBox.add(smallBox);

        System.out.printf("Price: " + bigBox.getPrice());
    }
}
