package com.demo.util;

import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T> {

    private static final String EMPTY_EX_MSG = "Empty Queue";

    private final Stack<T> in;
    private final Stack<T> out;

    public ImmutableQueue() {
        this.in = new ImmutableStack<>();
        this.out = new ImmutableStack<>();
    }

    private ImmutableQueue(Stack<T> in, Stack<T> out) {
        if (out.isEmpty()) {
            this.in = new ImmutableStack<>();
            this.out = in.reverse();
        } else {
            this.in = in;
            this.out = out;
        }
    }

    @Override
    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(in.push(t), out);
    }

    @Override
    public Queue<T> deQueue() {
        if (this.isEmpty())
            throw new UnsupportedOperationException(EMPTY_EX_MSG);
        return new ImmutableQueue<>(in, out.pop());
    }

    @Override
    public T head() {
        if (this.isEmpty())
            throw new NoSuchElementException(EMPTY_EX_MSG);
        return out.peek();
    }

    @Override
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}
