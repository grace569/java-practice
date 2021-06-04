package com.queue;
import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable{
    private BlockingQueue<Product> bq;

    public ConsumerQueue(BlockingQueue blockingQueue){
        this.bq = blockingQueue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Product product = bq.take();
                System.out.println("Consumer has purchased " + product.getBrand() + "----" + product.getName());
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
