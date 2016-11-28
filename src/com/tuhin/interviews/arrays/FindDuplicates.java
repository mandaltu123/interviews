package com.tuhin.interviews.arrays;


/**
 * Created by tuhinmandal on 23/11/16.
 * given an array of 5 integers (max integer value is less than or equal to the length of the array)
 * find out the duplicates in that array.
 */
public class FindDuplicates {

    public static void main(String[] args) {
        FindDuplicates duplicate = new FindDuplicates();
        int arr[] = {1, 1, 2, 4, 5, 3};
        int arr_size = arr.length;
        duplicate.printDuplicates(arr, arr_size);
    }

    void printDuplicates(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }
}
