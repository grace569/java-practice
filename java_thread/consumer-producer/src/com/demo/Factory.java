package com.demo;

public class Factory {
    public static void main(String[] args) {

        Product factoryProduct = new Product();

        Producer producer = new Producer(factoryProduct);
        Consumer consumer = new Consumer(factoryProduct);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
