package org.kodluyoruz;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main th starting");

        Thread th1 = new Thread(new AddTask<Integer>(1));
        Thread th2 = new Thread(new AddTask<Integer>(2));

        Thread th3 = new Thread(new PeekTask<>());

        Thread th4 = new Thread(new PollTask<>());

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try {
            th1.join();
            th2.join();
            th3.join();
            th3.join();

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Main th finish");
    }
}