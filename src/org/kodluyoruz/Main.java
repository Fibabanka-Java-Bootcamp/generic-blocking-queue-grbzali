package org.kodluyoruz;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main th starting");

        Semaphore semaphore = new Semaphore(1);

        QThread<Integer> th1 = new QThread<>(semaphore,"add", 1);
        //QThread<Integer> th2 = new QThread<>(semaphore,"poll");

        th1.start();
        //th2.start();

        try {
            th1.join();
            //th2.join();



        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Main th finish");
    }
}