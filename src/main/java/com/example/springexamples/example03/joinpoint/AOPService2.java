package com.example.springexamples.example03.joinpoint;

import org.springframework.stereotype.Service;

@Service
public class AOPService2 {
    public String welcome(String name) {
        return "welcome " + name;
    }
}
