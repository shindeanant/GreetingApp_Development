package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;

import org.apache.catalina.User;

public  interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(User user);
}