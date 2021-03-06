package com.demo.util;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ImmutableStack<T> implements Stack<T> {

    private final T head;
    private final ImmutableStack<T> tail;

    private ImmutableStack() {
        this(null, null);
    }

    private ImmutableStack(T head, ImmutableStack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public static ImmutableStack getEmptyStack() {
        return EmptyStack.getInstance();
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public Stack<T> pop() {
        if (tail.isEmpty())
            return getEmptyStack();
        return new ImmutableStack<T>(tail.head, tail.tail);
    }

    @Override
    public T peek() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Stack<T> reverse() {
        return recursiveReverse(this, getEmptyStack());
    }

    private Stack<T> recursiveReverse(Stack<T> source, Stack<T> result) {
        if (source.isEmpty())
            return result;
        return recursiveReverse(source.pop(), result.push(source.peek()));
    }

    private static class EmptyStack<T> extends ImmutableStack<T> {

        private static final String EMPTY_EX_MSG = "Empty Stack";

        private static EmptyStack emptyStack;

        private EmptyStack() {
        }

        private static EmptyStack getInstance() {
            if (Objects.isNull(emptyStack))
                emptyStack = new EmptyStack();
            return emptyStack;
        }

        @Override
        public Stack<T> push(T t) {
            return super.push(t);
        }

        @Override
        public Stack<T> pop() {
            throw new UnsupportedOperationException(EMPTY_EX_MSG);
        }

        @Override
        public T peek() {
            throw new NoSuchElementException(EMPTY_EX_MSG);
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Stack<T> reverse() {
            return emptyStack;
        }
    }
}
