package com.demo;

public class Demo extends Thread {

    @Override
    public void run() {
        for (int i =0; i <10; i++) {
            System.out.println(Thread.currentThread().getName() + "-----------" + i);
        }
    }
    public static void main(String[] args) {
        Demo threadDemo = new Demo();
        threadDemo.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "+++++++++++" + i);
        }
    }
}
