package com.tuhin.interviews.linkedlists;

/**
 * @author tuhinmandal on 18/08/16.
 */
public class LinkedListLengthRecursively {

    public int length(Node head) {

        if (head == null) {
            return 0;
        }

        return 1 + length(head.next);
    }
}
