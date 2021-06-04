package com.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Factory {
    public static void main(String[] args) {
        BlockingQueue bq = new ArrayBlockingQueue(5);
        ProducerQueue producerQueue = new ProducerQueue(bq);
        ConsumerQueue consumerQueue = new ConsumerQueue(bq);

        new Thread(producerQueue).start();
        new Thread(consumerQueue).start();
    }
}
