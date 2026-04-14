package com.example.MyApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev  {
    @Autowired
//    @Qualifier("desktop")
    private Computer comp;

    public void build(){
        comp.compile();
        System.out.println("Working for Awesome Project");
    }
}
