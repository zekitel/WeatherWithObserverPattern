package com.okan.Controller;

import com.netflix.discovery.EurekaClient;
import com.okan.Main;
import com.okan.Weather.RestObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Qualifier("eurekaClient")
    @Autowired
    public EurekaClient eurekaClient;


    @RequestMapping(value = "/registerObserver", method = RequestMethod.POST)
    public void registerObserver(@RequestParam(value="serviceName") String serviceName) {
        RestObserver restObserver = new RestObserver(eurekaClient, serviceName);
        Main.weather.register(restObserver);
    }

}
