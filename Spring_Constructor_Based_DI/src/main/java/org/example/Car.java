package org.example;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        boolean status = engine.start();
        if (status) {
            System.out.println("Car :: Engine Start Successfully");
        } else System.out.println("Car :: Engine Failed To Start");
    }
}
