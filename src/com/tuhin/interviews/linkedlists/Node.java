package com.tuhin.interviews.linkedlists;

/**
 * Each node of a linkedlist
 * This is an implementation of singly linkedlist so class contains
 * element and next pointer, no previous pointer
 * Created by tuhinmandal on 04/07/16.
 * <p/>
 * <p/>
 * This is an implementation of singly sinnkedlist.
 * <p/>
 * Linked lists are linear datastructures.
 * Singly linkedlsit can be travesed in only one direction. Next pointer hold the address to
 * it's next element. Linked list does not get allocated in contiguous memory locations unlike
 * arrays.
 * <p/>
 * Linked list traversals are O(n) time.
 * Add or delete is also O(n) as you need to traverse till the point you find the node after which
 * the new node to be inserted or the one to be deleted.
 * <p/>
 * Here is the comparison of linkedlist and arraylist if you are coming from java backgorund :
 * <p/>
 * ==============
 * Stack overflow discussions :
 * http://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist
 * <p/>
 * LinkedList and ArrayList are two different implementations of the List interface. LinkedList implements it with a
 * doubly-linked list. ArrayList implements it with a dynamically re-sizing array.
 * <p/>
 * As with standard linked list and array operations, the various methods will have different algorithmic runtimes.
 * <p/>
 * For LinkedList<E>
 * <p/>
 * get(int index) is O(n/4) average
 * add(E element) is O(1)
 * add(int index, E element) is O(n/4) average
 * but O(1) when index = 0 <--- main benefit of LinkedList<E>
 * remove(int index) is O(n/4) average
 * Iterator.remove() is O(1) <--- main benefit of LinkedList<E>
 * ListIterator.add(E element) is O(1) <--- main benefit of LinkedList<E>
 * Note: O(n/4) is average, O(1) best case (e.g. index = 0), O(n/2) worst case (middle of list)
 * <p/>
 * For ArrayList<E>
 * <p/>
 * get(int index) is O(1) <--- main benefit of ArrayList<E>
 * add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
 * add(int index, E element) is O(n/2) average
 * remove(int index) is O(n/2) average
 * Iterator.remove() is O(n/2) average
 * ListIterator.add(E element) is O(n/2) average
 * Note: O(n/2) is average, O(1) best case (end of list), O(n) worst case (start of list)
 * <p/>
 * LinkedList<E> allows for constant-time insertions or removals using iterators, but only sequential access of
 * elements. In other words, you can walk the list forwards or backwards, but finding a position in the list takes
 * time proportional to the size of the list. Javadoc says "operations that index into the list will traverse the
 * list from the beginning or the end, whichever is closer", so those methods are O(n/4) on average, though O(1) for
 * index = 0.
 * <p/>
 * ArrayList<E>, on the other hand, allow fast random read access, so you can grab any element in constant time.
 * But adding or removing from anywhere but the end requires shifting all the latter elements over, either to make an
 * opening or fill the gap. Also, if you add more elements than the capacity of the underlying array, a new array
 * (1.5 times the size) is allocated, and the old array is copied to the new one, so adding to an ArrayList is O(n)
 * in the worst case but constant on average.
 * <p/>
 * So depending on the operations you intend to do, you should choose the implementations accordingly. Iterating over
 * either kind of List is practically equally cheap. (Iterating over an ArrayList is technically faster, but unless
 * you're doing something really performance-sensitive, you shouldn't worry about this -- they're both constants.)
 * <p/>
 * The main benefits of using a LinkedList arise when you re-use existing iterators to insert and remove elements.
 * These operations can then be done in O(1) by changing the list locally only. In an array list, the remainder of
 * the array needs to be moved (i.e. copied). On the other side, seeking in a LinkedList means following the links
 * in O(n), whereas in an ArrayList the desired position can be computed mathematically and accessed in O(1).
 * <p/>
 * Another benefit of using a LinkedList arise when you add or remove from the head of the list, since those operations
 * are O(1), while they are O(n) for ArrayList. Note that ArrayDeque may be a good alternative to LinkedList for adding
 * and removing from the head, but it is not a List.
 * <p/>
 * Also, if you have large lists, keep in mind that memory usage is also different. Each element of a LinkedList has
 * more overhead since pointers to the next and previous elements are also stored. ArrayLists don't have this overhead.
 * However, ArrayLists take up as much memory as is allocated for the capacity, regardless of whether elements have
 * actually been added.
 * <p/>
 * The default initial capacity of an ArrayList is pretty small (10 from Java 1.4 - 1.8). But since the underlying
 * implementation is an array, the array must be resized if you add a lot of elements. To avoid the high cost of
 * resizing when you know you're going to add a lot of elements, construct the ArrayList with a higher initial capacity.
 * <p/>
 * It's worth noting that Vector also implements the List interface and is almost identical toArrayList. The difference
 * is that Vector is synchronized, so it is thread-safe. Because of this, it is also slightly slower than ArrayList.
 * So as far as I understand, most Java programmers avoid Vector in favor of ArrayList since they will probably
 * synchronize explicitly anyway if they care about that.
 */


public class Node<E> {

    E element;
    Node next;
    Object object;


    public static Node newNode(int data, Object... objects) {
        Node node = new Node();
        node.next = null;
        node.element = data;
        if (objects != null && objects.length > 0) {
            node.object = objects[0];
        }

        return node;
    }
}
