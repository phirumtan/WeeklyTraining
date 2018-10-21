package com.example.weeklytraining;

import org.junit.Test;

public class CarTest {

    Car mCar;

    @Test
    public void defualtName() {
        Car car = new Car();
        System.out.println(car.name);

        Toyota toyota = new Toyota();
        toyota.drive();
        System.out.println(toyota.name);
    }

    @Test
    public void testCastingError() {
        Toyota toyota;
        Car car = new Car();
        toyota = (Toyota) car;//Error
        toyota.drive();
    }

    @Test
    public void testCastingSucess() {
        Toyota toyota;
        Car car = new Toyota();
        toyota = (Toyota) car;
        toyota.drive();
    }

    private String mSex;

    @Test
    public void testStatic() {
        mSex = Car.sex;
    }
}