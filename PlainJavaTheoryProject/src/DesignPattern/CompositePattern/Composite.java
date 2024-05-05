package DesignPattern.CompositePattern;

import java.util.ArrayList;
public class Composite implements Component{

    ArrayList<Component> arrayList = new ArrayList<>();

    void add(Component component){
        arrayList.add(component);
    }
    void remove(Component component){
        arrayList.remove(component);
    }

    @Override
    public int getPrice() {
        int price = 0;
        for(Component comp : arrayList){
            price+=comp.getPrice();
        }

        return price;
    }

}
