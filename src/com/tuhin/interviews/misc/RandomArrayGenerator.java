package com.tuhin.interviews.misc;

import java.util.Random;

/**
 * @author tuhinmandal on 20/08/16.
 */
public class RandomArrayGenerator {


    public static int[] arraySize50() {
        int[] array = new int[50];
        Random random = new Random();
        for (int i = 0; i< 50; i++) {
            final int j = random.nextInt(50) + 1;
            array[i] = j;
        }

        return array;
    }
}
