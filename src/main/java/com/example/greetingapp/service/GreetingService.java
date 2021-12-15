package com.example.greetingapp.service;

import java.util.concurrent.atomic.AtomicLong;

import com.example.greetingapp.model.Greeting;

public class GreetingService implements IGreetingService {
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();


    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }
    
}