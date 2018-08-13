package com.okan.Weather;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Weather implements Subject{
    Map<String,Integer> cityMap;
    LinkedList<Observer> observers;


    public void setCityMap(Map<String, Integer> cityMap) {
        this.cityMap = cityMap;
    }

    public Map<String, Integer> getCityMap() {
        return cityMap;
    }

    public Weather() {

        /*
        cityMap = new HashMap<String, Integer>();
        cityMap.put("Ankara",30);
        cityMap.put("Istanbul",30);
        cityMap.put("Izmır",30);
        */
        this.observers = new LinkedList<Observer>();

    }

    @Override
    public void register(Observer o) {
        observers.add(o);
        System.out.println("REGISTER: " + ((RestObserver)o).getServiceId());
    }

    public void updateData(Map<String,Integer> cityMap){
        this.cityMap=cityMap;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for(Observer o : observers){
            o.update(cityMap);
        }
    }
}
