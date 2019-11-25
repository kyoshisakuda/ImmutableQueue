package com.demo.util;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ImmutableQueue<T> implements Queue<T> {

    private final Stack<T> in;
    private final Stack<T> out;

    private ImmutableQueue() {
        this.in = ImmutableStack.getEmptyStack();
        this.out = ImmutableStack.getEmptyStack();
    }

    public static ImmutableQueue getEmptyQueue() {
        return EmptyQueue.getInstance();
    }

    private ImmutableQueue(Stack<T> in, Stack<T> out) {
        if (out.isEmpty()) {
            this.in = ImmutableStack.getEmptyStack();
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
        return new ImmutableQueue<>(in, out.pop());
    }

    @Override
    public T head() {
        return out.peek();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static class EmptyQueue<T> extends ImmutableQueue<T> {

        private static final String EMPTY_EX_MSG = "Empty Queue";

        private static EmptyQueue emptyQueue;

        private EmptyQueue() {
        }

        private static EmptyQueue getInstance() {
            if (Objects.isNull(emptyQueue))
                emptyQueue = new EmptyQueue();
            return emptyQueue;
        }

        @Override
        public Queue<T> enQueue(T t) {
            return super.enQueue(t);
        }

        @Override
        public Queue<T> deQueue() {
            throw new UnsupportedOperationException(EMPTY_EX_MSG);
        }

        @Override
        public T head() {
            throw new NoSuchElementException(EMPTY_EX_MSG);
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
