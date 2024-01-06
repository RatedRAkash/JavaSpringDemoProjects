package DesignPattern.ObserverPattern;

public class Main {

    public static void main(String[] args) {
        
        Observer user1 = new CurrentCondition();
        Observer user2 = new HeatIndex();
        Observer user3 = new Forecast();
        
        WeatherData dataSheet = new WeatherData();
        
        dataSheet.regOb(user1);
        dataSheet.regOb(user2);
        dataSheet.regOb(user3);
        
        dataSheet.mc();
        System.out.println("");
        dataSheet.removeOb(user2);
        dataSheet.mc();
        
    }
    
}
