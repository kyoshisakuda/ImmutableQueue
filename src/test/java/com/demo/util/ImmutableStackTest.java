package com.demo.util;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ImmutableStackTest {

    @Test
    public void isEmpty_whenNoElementsAdded_returnTrue() {
        Stack<String> stack = ImmutableStack.getEmptyStack();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmpty_whenAnElementIsAdded_returnFalse() {
        Stack<String> stack = ImmutableStack.getEmptyStack();
        stack = stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void push_returnNewStackWithElement() {
        Stack<String> oldStack = ImmutableStack.getEmptyStack();
        Stack<String> newStack = oldStack.push("A");
        assertNotSame(oldStack, newStack);
        assertFalse(newStack.isEmpty());
        assertTrue(oldStack.isEmpty());
    }

    @Test
    public void peek_whenHasElements_returnLastElementAdded() {
        Stack<String> stack = ImmutableStack.getEmptyStack();
        stack = stack.push("A");
        stack = stack.push("B");
        assertEquals("B", stack.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void peek_whenEmpty_throwNoSuchElementException() {
        Stack<String> stack = ImmutableStack.getEmptyStack();
        stack.peek();
    }

    @Test
    public void pop_returnNewStackWithoutLastElement() {
        Stack<String> oldStack = ImmutableStack.getEmptyStack();
        oldStack = oldStack.push("A");
        Stack<String> newStack = oldStack.pop();
        assertNotSame(oldStack, newStack);
        assertTrue(newStack.isEmpty());
        assertFalse(oldStack.isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void pop_whenEmpty_throwUnSupportedOperationException() {
        Stack<String> stack = ImmutableStack.getEmptyStack();
        stack.pop();
    }

    @Test
    public void reverse_returnNewStackReversed() {
        Stack<String> oldStack = ImmutableStack.getEmptyStack();
        oldStack = oldStack.push("A");
        oldStack = oldStack.push("B");
        oldStack = oldStack.push("C");
        oldStack = oldStack.push("D");

        Stack<String> newStack = oldStack.reverse();
        assertEquals("A", newStack.peek());
        newStack = newStack.pop();
        assertEquals("B", newStack.peek());
        newStack = newStack.pop();
        assertEquals("C", newStack.peek());
        newStack = newStack.pop();
        assertEquals("D", newStack.peek());
    }

    @Test
    public void reverse_whenEmpty_returnEmptyStack() {
        Stack<String> oldStack = ImmutableStack.getEmptyStack();
        Stack<String> newStack = ImmutableStack.getEmptyStack();
        assertTrue(newStack.isEmpty());
    }
}