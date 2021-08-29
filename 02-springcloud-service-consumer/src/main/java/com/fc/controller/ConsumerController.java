package com.fc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/hello")
    public String hello(){
        //调用springCloud服务提供者提供的服务
//        return restTemplate.getForEntity("http://localhost:8080/provide/hello",String.class).getBody();
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/provide/hello",String.class).getBody();

    }
    @RequestMapping("/test")
    public String test(){
        ResponseEntity<String> body = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/provide/hello", String.class);
        HttpStatus statusCode = body.getStatusCode();
        int statusCodeValue = body.getStatusCodeValue();
        HttpHeaders headers = body.getHeaders();
        String body1 = body.getBody();
        System.out.println("---"+statusCode);
        System.out.println("---"+statusCodeValue);
        System.out.println("---"+body1);
        System.out.println("---"+headers);


        return "test";
    }
}
