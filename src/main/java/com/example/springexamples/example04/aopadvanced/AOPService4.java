package com.example.springexamples.example04.aopadvanced;

import org.springframework.stereotype.Service;

@Service
public class AOPService4 {
    public String getName(String name) {
        return "welcome " + name;
    }
}
