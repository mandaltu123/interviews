package com.tuhin.interviews.sorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * Class mergesort.
 * <p/>
 * Merge sort is a divide and concur algorithm which has better running time than
 * insertion, selection or bubble sort.
 * Merge sort runs on O(nlogn) time for worst, best or average cases but the downside of it is
 * it uses auxiliary arrays for storing divided arrays which may lead to some memory issues in case the
 * array is really large.
 * <p/>
 * How merge dividing gives logn time where in the merge algorithm runs on O(n) in worst case,
 * in combination the total complexity is O(nlogn).
 * To get the details we can look at this stack overflow link:
 * http://stackoverflow.com/questions/7801861/why-is-merge-sort-worst-case-run-time-o-n-log-n
 *
 * Merge sort works well if the size of the array is at least 50 or more. where in insertion sort
 * or selection sort works better if the size is 5-10.
 *
 * @author tuhinmandal on 19/08/16.
 */
public class MergeSort {

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        //left array size
        int nL = middle - left + 1;
        // right array size
        int nR = right - middle;

        // two temporary sub arrays for left and right divided parts
        int[] L = new int[nL];
        int[] R = new int[nR];
        // int iP = left; // index in the main array
        int iP = left;
        int iL = 0; // index of the left array
        int iR = 0; // index of the right array

        // copy data to temporary array

        for (int i = 0; i < nL; ++i) {
            L[i] = array[left + i];
        }

        for (int j = 0; j < nR; ++j) {
            R[j] = array[middle + 1 + j];
        }


        // we will be comparing left and right sub arrays and merging their values back to parent array
        // remember this comparison happens starting for first element in the sub arrays

        while (iL < nL && iR < nR) {
            if (L[iL] <= R[iR]) {
                array[iP] = L[iL];
                iL++;
            } else {
                array[iP] = R[iR];
                iR++;
            }
            iP++;
        }
        //it may happen that one of the arrays may get exhausted before the other one, in that case
        // we will be left with some elements in one of the arrays.we have to merge those left over
        // elements as well

        //checking left array
        while (iL < nL) {
            array[iP] = L[iL];
            iL++;
            iP++;
        }

        // checking right array
        while (iR < nR) {
            array[iP] = R[iR];
            iR++;
            iP++;
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {8, 3, 9, 7, 10, 1, 2, 4, 6, 5};
        int left = 0;
        int right = array.length - 1;
        mergeSort.mergeSort(array, left, right);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
