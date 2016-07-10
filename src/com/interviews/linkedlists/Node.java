package com.interviews.linkedlists;

/**
 * Each node of a linkedlist
 * This is an implementation of singly linkedlist so class contains
 * element and next pointer, no previous pointer
 * Created by tuhinmandal on 04/07/16.
 */
public class Node<E> {

    private E element;
    private Node next;

    /**
     * Constructor with element item to be set to each node
     *
     * @param data
     */
    public Node(E data) {
        this.element = data;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
