package DesignPattern.ObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject{

    ArrayList<Observer> Ob_arr = new ArrayList<>(); 
    
    
    void getTemp(){
        System.out.println("Temperature");
    };
    
    void getHum(){
        System.out.println("Humidity");
    };
    
    void getPressure(){
        
        System.out.println("Pressure");
    };
    
    

    @Override
    public void regOb(Observer Ob) {
        Ob_arr.add(Ob);
    }

    
    @Override
    public void removeOb(Observer Ob) {
           for (int coun = 0; coun < Ob_arr.size(); coun++) {      
               {
                   if(Ob==Ob_arr.get(coun))
                   {
                       Ob_arr.remove(Ob_arr.get(coun));
                       break;
                   }
               }
            }  
    }

    
    @Override
    public void notifyOb(Observer Ob) {
        Ob.update();
    }
    
    
    void mc(){
        for(int coun=0;coun<Ob_arr.size();coun++)
        {
            notifyOb(Ob_arr.get(coun));
        }
    }
       
    
}