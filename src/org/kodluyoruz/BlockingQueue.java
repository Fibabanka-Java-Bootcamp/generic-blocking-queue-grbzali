package org.kodluyoruz;

public class BlockingQueue<T> implements IQueue<T> {

    private Node<T> rear;
    private Node<T> front;

    @Override
    public synchronized void add(T value) {
        System.out.println(Thread.currentThread().getName() + " Starting add");
        Node<T> node = new Node<>(value);

        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.setNextNode(node);
            rear = node;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " Finish add"+ "eklenen değer: "+ value);
    }

    @Override
    public synchronized T peek() {
        System.out.println(Thread.currentThread().getName() + " Starting peek");
        if (!isEmpty()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
            System.out.println(Thread.currentThread().getName() + " Finish peek");
           return front.getValue();

        }else {
            return null;
        }
        //return !isEmpty() ? front.getValue() : null;


    }

    @Override
    public synchronized T poll() {
        System.out.println(Thread.currentThread().getName() + " Starting poll");
        T value = null;

        if (!isEmpty()) {
            Node<T> node = front;
            front = front.getNextNode();
            value = node.getValue();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " Finish poll"+ "silinen değer: " + value);
        return value;
    }

    @Override
    public synchronized boolean isEmpty() {

        return front == null;
    }

}
