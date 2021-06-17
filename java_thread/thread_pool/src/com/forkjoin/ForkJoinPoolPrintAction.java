package com.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolPrintAction {
    public static void main(String[] args) throws InterruptedException {
        PrintTask task = new PrintTask(0, 300);
        //submit tasks to pool to divide
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task);
        //wait for tasks to finish
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
