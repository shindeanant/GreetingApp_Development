package com.example.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    /* 
     *curl localhost:8080/greeting
     @return={id =1 , content="hello world!}
     * curllocalhost:8080/greeting?name=srikanth
     * @return= { id=2, content="hello srikanth!
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @Autowired
    private IGreetingService greetingService;

    /*
       *curl localhost:8080/greeting/service
       @return={id =1 , content="hello world!}
        */
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();

    }
}
    
   