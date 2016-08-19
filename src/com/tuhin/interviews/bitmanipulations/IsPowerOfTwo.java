package com.tuhin.interviews.bitmanipulations;

/**
 * @author tuhinmandal on 17/08/16.
 */
public class IsPowerOfTwo {

    /**
     * First approach is keep dividing the number with 2.
     * If the end reminder is 1 then it is power of 2 else not.
     * running time is O(logn)
     */

    public boolean isPowerTwo(int x) {

        //if x is 0 then obviously it is not power of two
        if (x == 0) {
            return false;
        } else {
            while (x % 2 == 0) {
                x /= 2;
            }
            return (x == 1);
        }
    }


  


    public static void main(String[] args) {
        IsPowerOfTwo obj = new IsPowerOfTwo();
        System.out.println(obj.isPowerTwo(0));
        System.out.println(obj.isPowerTwo(16));
    }
}
