package com.demo.util;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ImmutableQueueTest {

    @Test
    public void isEmpty_whenNoElementsAdded_returnTrue() {
        Queue<String> immutableQueue = ImmutableQueue.getEmptyQueue();
        assertTrue(immutableQueue.isEmpty());
    }

    @Test
    public void isEmpty_whenHasElements_returnFalse() {
        Queue<String> immutableQueue = ImmutableQueue.getEmptyQueue();
        immutableQueue = immutableQueue.enQueue("A");
        assertFalse(immutableQueue.isEmpty());
    }

    @Test
    public void enQueue_returnDifferentQueue() {
        Queue<String> oldQueue = ImmutableQueue.getEmptyQueue();
        Queue<String> newQueue = oldQueue.enQueue("A");
        assertNotSame(oldQueue, newQueue);
        assertTrue(oldQueue.isEmpty());
    }

    @Test
    public void enQueue_thenNewElementAdded() {
        Queue<String> oldQueue = ImmutableQueue.getEmptyQueue();
        Queue<String> newQueue = oldQueue.enQueue("A");
        assertEquals("A", newQueue.head());
    }

    @Test
    public void head_whenHasElements_returnFirstElement() {
        Queue<String> queue = ImmutableQueue.getEmptyQueue();
        queue = queue.enQueue("A");
        queue = queue.enQueue("B");
        queue = queue.enQueue("C");
        assertEquals("A", queue.head());
    }

    @Test(expected = NoSuchElementException.class)
    public void head_whenEmpty_throwNoSuchElementException() {
        Queue<String> queue = ImmutableQueue.getEmptyQueue();
        queue.head();
    }

    @Test
    public void deQueue_whenHasElements_thenFirstElementRemoved() {
        Queue<String> oldQueue = ImmutableQueue.getEmptyQueue();
        oldQueue = oldQueue.enQueue("A");
        oldQueue = oldQueue.enQueue("B");
        oldQueue = oldQueue.enQueue("C");
        oldQueue = oldQueue.enQueue("D");
        Queue<String> newQueue = oldQueue.deQueue();
        assertEquals("B", newQueue.head());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deQueue_whenEmpty_throwUnsupportedOperationException() {
        Queue<String> emptyQueue = ImmutableQueue.getEmptyQueue();
        emptyQueue.deQueue();
    }
}
