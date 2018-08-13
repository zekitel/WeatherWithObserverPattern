package com.example.springboot2.Controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class Controller   {
    Map<String,Object> data=new HashMap<String, Object>();

    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient eurekaClient;


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateWeather(@RequestParam(value="json_data")  String json_data){
        JSONObject json = new JSONObject(json_data);
        for(String key : json.keySet()){
            System.out.println(key + " - " + json.get(key));
            data.put(key,json.get(key));
        }
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public Map<String,Object> show(){
        return data;
    }

}
