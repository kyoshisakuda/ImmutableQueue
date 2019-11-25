package com.demo.util;

import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T> {

    private static final String EMPTY_EX_MSG = "Empty Queue";
    private static final ImmutableQueue EMPTY = new ImmutableQueue();

    private final Stack<T> in;
    private final Stack<T> out;

    private ImmutableQueue() {
        this.in = ImmutableStack.getEmptyStack();
        this.out = ImmutableStack.getEmptyStack();
    }

    private ImmutableQueue(Stack<T> in, Stack<T> out) {
        if (out.isEmpty()) {
            this.out = in.reverse();
            this.in = ImmutableStack.getEmptyStack();
        } else {
            this.in = in;
            this.out = out;
        }
    }

    public static ImmutableQueue getEmptyQueue() {
        return EMPTY;
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
