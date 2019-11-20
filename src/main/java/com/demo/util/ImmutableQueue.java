package com.demo.util;

public class ImmutableQueue<T> implements Queue<T> {

    private Element<T> head;
    private Element<T> tail;

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

    public Element<T> getHead() {
        return head;
    }

    public Element<T> getTail() {
        return tail;
    }

    class Element<T> {

        private T value;
        private Element<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }

    }

}
