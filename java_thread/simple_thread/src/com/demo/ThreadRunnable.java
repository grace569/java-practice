package com.demo;


public class ThreadRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + "---------------" + i);
        }
    }

    public static void main(String[] args) {
        ThreadRunnable tr = new ThreadRunnable();
        Thread thread = new Thread(tr);
        thread.start();

        for (int i = 0; i<5; i++){
            System.out.println(Thread.currentThread().getName() + "---------------" + i);
        }

    }
}
