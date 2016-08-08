package com.tuhin.interviews.linkedlists;

import java.util.LinkedList;

/**
 * Array based implementation of linked list
 * Created by tuhinmandal on 04/07/16.
 */
public class LinkedListImplementation<E> {

    /**
     * Insertion into a linked list
     * @param head
     * @param data
     * @param objArray
     * @return
     */
    public Node addNode(Node head, int data, Object[] objArray) {

        Node temp = head;
        Node node = null;
        if(objArray != null && objArray.length > 0) {
            node = Node.newNode(data, objArray[0]);
        } else {
            node = Node.newNode(data);
        }

        if(head == null) {
            return  node;
        }

        while (head != null) {
                head = head.next;
        }
        head.next = node;
        return temp;
    }




}
