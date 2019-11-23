package com.demo.util;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ImmutableQueue<T> implements Queue<T> {

    private Stack<T> in;
    private Stack<T> out;

    public ImmutableQueue() {
        this.in = new ImmutableStack<>();
        this.out = new ImmutableStack<>();
    }

    private ImmutableQueue(Stack<T> in, Stack<T> out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(in.push(t), out);
    }

    @Override
    public Queue<T> deQueue() {
        if (this.isEmpty())
            throw new UnsupportedOperationException("Empty Queue");
        if (out.isEmpty())
            out = in.reverse();
        return new ImmutableQueue<>(in, out.pop());
    }

    @Override
    public T head() {
        if (this.isEmpty())
            throw new NoSuchElementException("Empty Queue");
        if (out.isEmpty())
            out = in.reverse();
        return out.peek();
    }

    @Override
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}
