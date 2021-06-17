package com.forkjoin;

import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction {
    private static final int THRESHOLD = 50; //print 50 nums max
    private int start;
    private int end;

    public PrintTask(int start, int end){
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "'s i = " + i);
            }
        } else {
            int middle = (start + end)/2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            //run two sub tasks
            left.fork();
            right.fork();
        }
    }
}
