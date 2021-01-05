package org.kodluyoruz;

public class PeekTask<T> implements Runnable{
    BlockingQueue<T> queue = new BlockingQueue<T>();

    @Override
    public void run() {

        queue.peek();

    }
}
