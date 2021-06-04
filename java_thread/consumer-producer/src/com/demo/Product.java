package com.demo;

public class Product {

    private String brand;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public synchronized void get() {
        System.out.printf("The consumer has purchased a %s ---- %s \n", this.getBrand(), this.getName());
    }

    public synchronized void set(String brand, String name) {
        this.setBrand(brand);
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.printf("The producer has produced a %s ---- %s \n", this.getBrand(), this.getName());
    }
}
