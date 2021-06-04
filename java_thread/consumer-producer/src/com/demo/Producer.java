package com.demo;
/**
 * Produce goods in the factory and put it in shared storage
 *
 * **/

public class Producer implements Runnable{

    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i%2 == 0) {
                product.set("Gucci", "Shoes");
            } else {
                product.set("La Mer", "Makeup");
            }
        }
    }
}
