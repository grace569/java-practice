package com.threadpoolexec;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        System.out.println(System.currentTimeMillis());
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("1------Delay for 1 second, run once every 3 seconds");
                System.out.println(System.currentTimeMillis());
            }
        },1,3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("2------Delay for 1 second, run once every 3 seconds");
                System.out.println(System.currentTimeMillis());
            }
        },1,3, TimeUnit.SECONDS);
        //scheduledExecutorService.shutdown();
    }
}
