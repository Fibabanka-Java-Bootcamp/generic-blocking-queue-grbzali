package org.kodluyoruz;

import java.util.concurrent.Semaphore;

public class QThread<T> extends Thread{

    String thName;
    Semaphore semaphore;
    BlockingQueue<T> queue;
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

                queue.add(value);
                Thread.sleep(10);

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
                queue.poll();
                Thread.sleep(10);

            }catch (Exception e) {
                System.out.println("Interrupt polls");

            }
        }
    }
}
