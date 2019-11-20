package com.demo.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class ImmutableQueueTest {

    @Test
    public void enQueue_thenReturnDifferentQueue() {
        Queue<String> queue = new ImmutableQueue();
        Queue<String> newQueue = queue.enQueue("new element");
        assertNotSame(queue, newQueue);
    }

}
