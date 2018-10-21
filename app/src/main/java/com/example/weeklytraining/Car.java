package com.example.weeklytraining;

public class Car {

    public String name;

    public static String sex;

    private String phone;

    public Car() {
        name = "Toyota";
        this.phone = "0120000";
    }

    public void drive() {
        System.out.println("Going down the road!");
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    private String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }
}
