package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private Engine engine;

    public void drive() {
        boolean status = engine.start();
        if (status) {
            System.out.println("Car :: Engine Start Successfully");
        } else System.out.println("Car :: Engine Failed To Start");
    }
}
