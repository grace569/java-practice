package com.ticket;

/**
 * Using Runnable interface to solve the issue of tickets not selling from the same source
 * Passing the same runnable to threads as the source of the tickets
 * **/

public class TicketRunnable implements Runnable{
    private int ticketAmount = 5;

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            synchronized (this){
                if (ticketAmount > 0){
                    System.out.println(Thread.currentThread().getName() + "Ticket Number " + (ticketAmount--) + " is being sold");
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketRunnable tr = new TicketRunnable();
        Thread t1 = new Thread(tr, "A");
        Thread t2 = new Thread(tr, "B");
        Thread t3 = new Thread(tr,"C");
        Thread t4 = new Thread(tr, "D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
