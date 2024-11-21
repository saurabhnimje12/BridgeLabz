package org.example;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public Engine() {
        System.out.println("Engine :: Default-Constructor");
    }

    public boolean start() {
        return true;
    }
}
