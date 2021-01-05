package org.kodluyoruz;

public class PollTask<T> implements Runnable{
    BlockingQueue<T> queue = new BlockingQueue<T>();
    @Override
    public void run() {

        queue.poll();

    }
}
