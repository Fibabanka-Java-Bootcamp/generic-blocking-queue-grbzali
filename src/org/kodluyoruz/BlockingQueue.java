package org.kodluyoruz;

import java.util.concurrent.Semaphore;

public class BlockingQueue<T> implements IQueue<T> {


    private Node<T> rear;
    private Node<T> front;


    @Override
    public void add(T value) {
        System.out.println(Thread.currentThread().getName() + " Starting add");
            Node<T> node = new Node<>(value);

            if (isEmpty()) {
                front = node;
                rear = node;
                System.out.println("eklenen değer: " + rear.getValue());
            } else {
                rear.setNextNode(node);
                rear = node;
                System.out.println("eklenen değer: " + rear.getValue());
            }


    }

    @Override
    public T peek() {
        System.out.println(Thread.currentThread().getName() + " Starting peek");

            if (!isEmpty()) {


                return front.getValue();
            }
            return null;

        //return !isEmpty() ? front.getValue() : null;

    }

    @Override
    public T poll() {
        System.out.println(Thread.currentThread().getName() + " Starting poll");

            T value = null;

            if (!isEmpty()) {
                Node<T> node = front;
                front = front.getNextNode();
                value = node.getValue();
            }

            return value;
    }

    public void sleep(int msTime){
        try {
            Thread.sleep(msTime);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
    }

    @Override
    public boolean isEmpty() {

        return front == null;
    }

}
