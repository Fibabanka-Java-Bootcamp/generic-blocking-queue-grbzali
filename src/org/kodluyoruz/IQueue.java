package org.kodluyoruz;

import java.util.concurrent.Semaphore;

public interface IQueue<T> {

     void add(T value);

     T peek();

     T poll();

     boolean isEmpty();
}


