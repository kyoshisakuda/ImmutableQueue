package com.demo.util;

public interface Queue<T> {

    public Queue<T> enQueue(T t);

    public Queue<T> deQueue();

    public T head();

    public boolean isEmpty();

}
