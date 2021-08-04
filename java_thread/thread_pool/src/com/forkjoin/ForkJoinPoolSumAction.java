package com.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinPoolSumAction {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[100];
        Random random = new Random();
        int total = 0;
        //initialize arr with random values
        for (int i = 0; i < arr.length; i++){
            int temp = random.nextInt(20);
            total += (arr[i] = temp);
        }
        System.out.println("The sum of initial arr is " + total);
        SumTask task = new SumTask(arr, 0, arr.length);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(task);
        System.out.println("Result of threads execution is " + future.get());
    }
}
