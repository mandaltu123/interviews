package com.interviews.stacks;

/**
 * Created by tuhinmandal on 04/07/16.
 */
public class StackArrayTester {

    public static void main(String args[]) {
        StackArray<Integer> stackArray = new StackArray<Integer>(10);
        stackArray.push(1);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(8);
        System.out.println(stackArray);
        int poppedItem = stackArray.pop();
        System.out.println("poppedItem = " + poppedItem);
        System.out.println("after pop: " + stackArray);
    }

}
