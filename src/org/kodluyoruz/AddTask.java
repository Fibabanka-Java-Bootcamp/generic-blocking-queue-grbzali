package org.kodluyoruz;

public class AddTask<T> implements Runnable{
    BlockingQueue<T> queue = new BlockingQueue<T>();
    private T value;

    public AddTask(T value){
        this.value = value;

    }

    @Override
    public void run() {
        queue.add(value);

    }
}
