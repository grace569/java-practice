package com.ticket;

/**
 * Demo usage of threads using the example of ticket selling
 * Threads are running at the same time, but not grabbing tickets from the same resource
 * **/

public class TicketThread extends Thread{
    private int ticketAmount = 5;

    @Override
    public void run() {
        if (ticketAmount > 0){
            System.out.println(Thread.currentThread().getName() + "Ticket Number " + (ticketAmount--) + " is being sold");
        }
    }

    public static void main(String[] args) {


        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();
        TicketThread t4 = new TicketThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
