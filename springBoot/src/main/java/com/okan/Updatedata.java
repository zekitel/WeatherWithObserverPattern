package com.okan;

import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Updatedata implements Runnable {
    Random rnd = new Random();

    int data=30;
    Map<String,Integer> cityMap= new HashMap<String,Integer>();

    public Updatedata(){
        cityMap.put("Ankara",30);
        cityMap.put("Izmir",30);
        cityMap.put("Istanbul",30);

    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public void run(){
        try {
            while (true) {


                Random temp=new Random();


                    int oldValueAnkara=cityMap.get("Ankara");
                    oldValueAnkara=oldValueAnkara+temp.nextInt(3)-1;
                    cityMap.put("Ankara",oldValueAnkara);




                int oldValueIst=cityMap.get("Istanbul");
                oldValueIst=oldValueIst+temp.nextInt(3)-1;
                cityMap.put("Istanbul",oldValueIst);



                int oldValueIzm=cityMap.get("Izmir");
                oldValueIzm=oldValueIzm+temp.nextInt(3)-1;
                cityMap.put("Izmir",oldValueIzm);
                Main.weather.updateData(cityMap);


                    Thread.sleep(3000);





            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
