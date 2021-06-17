package com.threadpoolexec;

import java.util.concurrent.*;

public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<20; i++){
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
