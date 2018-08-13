package com.okan;

import com.okan.Weather.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    public static Updatedata updatedata;
    public static Weather weather;
    public static void main(String[] args) {
        updatedata = new Updatedata();
        weather = new Weather();
        Thread th = new Thread(updatedata);
        th.start();
        SpringApplication.run(Main.class, args);

    }
}
