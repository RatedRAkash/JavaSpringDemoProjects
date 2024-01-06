package DesignPattern.ObserverPattern;

public interface Subject {
    
    void regOb(Observer ob);
    void removeOb(Observer ob);
    void notifyOb(Observer ob);

}
