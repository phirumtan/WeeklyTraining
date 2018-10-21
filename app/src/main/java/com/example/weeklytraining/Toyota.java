package com.example.weeklytraining;

public class Toyota extends Car{

    @Override
    public void drive() {
        System.out.println("Going Up the road!");
        super.drive();
        System.out.println("Going down1 the road!");
    }
}
