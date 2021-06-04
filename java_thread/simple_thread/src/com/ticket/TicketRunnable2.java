package com.ticket;

public class TicketRunnable2 implements Runnable{
    private int ticketAmount = 5;

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            this.sale();
        }
    }

    public  synchronized void sale(){
        if (ticketAmount > 0){
            System.out.println(Thread.currentThread().getName() + " Ticket Number " + (ticketAmount--) + " is being sold");
        }
    }

    public static void main(String[] args) {
        TicketRunnable2 tr = new TicketRunnable2();
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
