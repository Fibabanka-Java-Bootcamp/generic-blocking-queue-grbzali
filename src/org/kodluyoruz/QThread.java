package org.kodluyoruz;

import java.util.concurrent.Semaphore;

public class QThread<T> extends Thread{

    String thName;
    Semaphore semaphore;
    BlockingQueue<T> queue = new BlockingQueue<>();
    T value;

    public QThread(Semaphore semaphore, String thName){
        super(thName);
        this.semaphore = semaphore;
        this.thName = thName;
    }
    public QThread(Semaphore semaphore, String thName, T value){
        super(thName);
        this.semaphore = semaphore;
        this.thName = thName;
    }
    @Override
    public void run() {
        if (this.getName().equals("add")){
            System.out.println("starting" + thName);
            try {
                System.out.println(thName + " is waiting for a permit.");

                semaphore.acquire();

                System.out.println(thName + " gets a permit.");

                System.out.println("ADD OK");
                //queue.add(value);
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Interrupt add");

            }
        System.out.println(thName + " releases the permit.");
        semaphore.release();

        }else {
            System.out.println("starting" + thName);
            try {
                System.out.println(thName + " is waiting for a permit.");

                semaphore.acquire();
                System.out.println(thName + " gets a permit.");
                System.out.println("POLL OK");
                //queue.poll();
                Thread.sleep(1000);
                System.out.println(thName + " releases the permit.");
                semaphore.release();
            }catch (Exception e) {
                System.out.println("Interrupt polls");

            }
        }
    }
}
