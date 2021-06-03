package com.ticket;

/**
 * Using Runnable interface to solve the issue of tickets not selling from the same source
 * Passing the same runnable to threads as the source of the tickets
 * **/

public class TicketRunnable implements Runnable{
    private int ticketAmount = 5;

    @Override
    public void run() {
        if (ticketAmount > 0){
            System.out.println(Thread.currentThread().getName() + "Ticket Number " + (ticketAmount--) + " is being sold");
        }
    }

    public static void main(String[] args) {
        TicketRunnable tr = new TicketRunnable();
        Thread t1 = new Thread(tr);
        Thread t2 = new Thread(tr);
        Thread t3 = new Thread(tr);
        Thread t4 = new Thread(tr);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
