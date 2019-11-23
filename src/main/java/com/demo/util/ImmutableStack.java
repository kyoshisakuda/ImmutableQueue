package com.demo.util;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ImmutableStack<T> implements Stack<T> {

    private final T head;
    private final ImmutableStack<T> tail;

    public ImmutableStack() {
        this(null, null);
    }

    private ImmutableStack(T head, ImmutableStack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public Stack<T> pop() {
        if (this.isEmpty())
            throw new UnsupportedOperationException("Stack is empty");
        return new ImmutableStack<T>(tail.head, tail.tail);
    }

    @Override
    public T peek() {
        if (this.isEmpty())
            throw new NoSuchElementException("Stack is empty");
        return head;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    @Override
    public Stack<T> reverse() {
        Stack<T> reversedStack = new ImmutableStack<>();
        Stack<T> temp = this;
        while (!temp.isEmpty()) {
            reversedStack = reversedStack.push(temp.peek());
            temp = temp.pop();
        }
        return reversedStack;
    }
}
