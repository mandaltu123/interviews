package com.interviews.stacks;

import java.util.ArrayList;

/**
 * Created by tuhinmandal on 04/07/16.
 * Array based implementation of stack.
 */
public class StackArray<E> {

    private int top;
    private int capacity;
    private Object[] array;
    private E data;

    /**
     * Ideally users should not be let to provide capacity but this is
     * the very basic implementation of stack.
     *
     * @param capacity
     */
    public StackArray(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
        top = -1;
    }

    /**
     * Since top = -1 means the stack is empty, we have not added anything yet to the stack
     *
     * @return true if top == -1 else false
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Returns true if stack is full else returns false
     *
     * @return true if top == capacity -1, which means the stack is full
     */
    public boolean isStackFull() {
        return (top == capacity - 1);
    }

    /**
     * pushes the data to the stack incrementing top by one
     *
     * @param data: value to be pushed to the queue
     */
    public void push(E data) {
        if (isStackFull()) {
            System.out.println("can't insert. stack is full");
            return;
        } else {
            array[++top] = data;
        }
    }

    /**
     * Checks whether the stack is empty or not.
     * If not empty it returns the value from the top and top is set to point to
     * the second last inserted element
     *
     * @return last inserted item
     */
    public E pop() {

        if (isEmpty()) {
            System.out.println("stack is empty. can't pop");
            return null;
        } else {
            return (E) array[--top];
        }
    }
}
