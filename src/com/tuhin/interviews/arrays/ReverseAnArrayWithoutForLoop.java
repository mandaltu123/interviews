package com.tuhin.interviews.arrays;

import java.util.Scanner;

/**
 * Created by tuhinmandal on 28/11/16.
 * when I am asked to write this without a for loop I can use recursion I suppose.
 * Though recursive method usages are discouraged in production environments.
 */
public class ReverseAnArrayWithoutForLoop {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int length = arr.length;
        new ReverseAnArrayWithoutForLoop().reverseMe(arr, length);
    }

    public void reverseMe(int[] input, int length) {
        if (input == null || input.length == 0) {
            return;
        }
        if (length == 0 || length == -1 || length > input.length) {
            return;
        }
        System.out.print(input[length - 1] + " ");
        reverseMe(input, length - 1);

    }


}
