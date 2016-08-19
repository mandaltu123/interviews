package com.tuhin.interviews.sorting;

/**
 * Insertion sort is can be considered as suffling a deck of cards.
 * <p/>
 * consider that the left side of the array is sorted and right side is un sorted. we start from first element
 * <p/>
 * {9,    | 3, 5, 8, 2, 4}
 * sorted | un sorted
 * <p/>
 * now outer loop starts from 1st position which is 3.
 * <p/>
 * compare 3 with it's left part which we assumed to be sorted.
 * if 3 is less than left element which is 9 , we need to insert 3 before 9 and 9 will be shifted one place
 * towards right.
 * keep repeating this process till outer loop reaches the length of the array.
 * we will have a sorted array.
 * <p/>
 * Time complexity is O(n2)
 *
 * Reference: https://www.youtube.com/watch?v=DFG-XuyPYUQ
 *
 * @author tuhinmandal on 19/08/16.
 */
public class InsertionSort {

    public void insertionSort(int[] array) {

        if (array.length < 1) {
            return;
        }
        //let's consider first element is the sorted portion and rest are unsorted
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i;
            // take one element out of un-sorted portion and compare to the elements in the sorted portion
            //and find the right place where the element to be inserted
            //moving element towards right to make place for the element to be inserted

            while (j > 0 && array[j - 1] > element) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            //insert the element here
            //inserting the element at the correct position in the sorted area
            array[j] = element;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 3, 5, 8, 2, 4};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
