package org.kodluyoruz;

public interface IQueue<T> {

     void add(T value);

     T peek();

     T poll();

     boolean isEmpty();
}


