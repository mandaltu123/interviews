package com.tuhin.interviews.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Selection sort can be considered as the re-arranging a dec kof cards.
 * We take the first element (i in the outer for loop) and consider that to be the minimum element in the array.
 * now we keep looking at all the element and check if any element is lesser than that element or not.
 * if we find an element smaller than the min (previously chosen) then we make that as min element.In each iteration
 * if we see that if there is another element which is smaller than the min, we make that element as new min and
 * swap them.
 * we keep repeating this process till outer loop runs till n-1
 * Time complexity of this algorithm is O(n2).
 * Space complexity O(1)
 * <p/>
 * Here is the reference : https://www.youtube.com/watch?v=f8hXR_Hvybo
 *
 * @author tuhinmandal on 19/08/16.
 */
public class SelectionSort {

    public void selectionSort(int[] array) {
        if (array.length <= 0) {
            return;
        }

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            //assume a min element
            int min = i;
            for (int j = i + 1; j < n; j++) {
                //find an element which is smaller than the chosen min element
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            //swap new smaller element
            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 8, 9, 5, 2, 4};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
