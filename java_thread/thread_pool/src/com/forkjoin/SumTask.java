package com.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 20; // max sum of 20 numbers for each sub task
    private int arr[];
    private int start;
    private int end;

    //sum of all the numbers in arr[]
    public SumTask(int[] arr, int start, int end) {
        super();
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum =0;
        if(end - start <THRESHOLD){
            for(int i = start; i < end; i++){
                System.out.println(Thread.currentThread().getName()+"'s i = "+ arr[i]);
                sum += arr[i];
            }
            return sum;
        } else {
            int middle = (start + end)/2;
            SumTask left = new SumTask(arr, start, middle);
            SumTask right = new SumTask(arr, middle, end);

            left.fork();
            right.fork();

            return left.join()+right.join();
        }
    }
}
