package com.tuhin.interviews.sorting;

/**
 * demonstrating quick sort
 *
 * @author tuhinmandal on 09/08/16.
 */
public class QuickSort {


    public void quickSort(int[] a, int start, int end) {

        if (start < end) {
            int partitionIndex = partition(a, start, end);
            quickSort(a, start, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, end);
        }
    }

    private int partition(int[] a, int start, int end) {

        int pivot = a[end];
        int partitionIndex = start;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                swap(a, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(a, partitionIndex, end);
        return partitionIndex;
    }

    private void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 8, 9, 2, 4};
        new QuickSort().quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
