package com.queue;

import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable{
    private BlockingQueue<Product> bq;

    public ProducerQueue(BlockingQueue blockingQueue) {
        this.bq = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Product product = null;
            if (i%2 == 0){
                product = new Product("Gucci", "Shoes");
            } else {
                product = new Product("La Mer", "Makeup");
            }
            System.out.println("Producer has produced " + product.getBrand() + "----" + product.getName());
            try {
                bq.put(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
