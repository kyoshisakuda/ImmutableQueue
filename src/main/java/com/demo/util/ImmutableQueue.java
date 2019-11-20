package com.demo.util;

public class ImmutableQueue<T> implements Queue<T> {

    public Queue<T> enQueue(T t) {
        return this;
    }

    public Queue<T> deQueue() {
        return null;
    }

    public T head() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

}
