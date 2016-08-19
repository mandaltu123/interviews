package com.tuhin.interviews.misc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Picking a random number from a given array
 * <p/>
 * sample try to pick a random pivot out of an given array input for quick sort
 *
 * @author tuhinmandal on 11/08/16.
 */
public class RandomNumberPicker {

    public static void main(String[] args) {
        final int[] input = {1, 6, 9, 0, 5, 3};
        final Random random = new Random();


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    int randomInput = random.nextInt(input.length);
                    int theRandom = input[randomInput];
                    System.out.println(theRandom);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }

    }
}
