package com.interviews.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuhinmandal on 13/07/16.
 */
public class PrintNodesLevelByLevel {

    /**
     * There are 2-3 ways to solve this problem
     * Here we are going to use one queue.
     * We take one queue and add root and a null value to it. Null will tell us when to print the new line.
     * Now we start iterating over the queue and check whether the popped value has a left / right.
     * If it has children we push them to the queue and print the popped value.
     * If the popped value is null (since in the beginning we added one null), we check whether the queue is
     * empty or not. If empty we are done.
     * If not empty we insert another null in the queue which will act as the pivot for printing new line.
     * <p/>
     * time complexity is O(n) as we have to visit each node.
     * Space complexity is O(n) as the queue may have all the leaf nodes at a time.
     * Result:
     * 10
     * -10 20
     * 0 15 30
     * -5 5 27
     *
     * @param root
     */

    public void printLevelByLevel(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            root = queue.poll();

            if (root != null) {
                System.out.print(root.data + " ");
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            }
        }
    }


    public static void main(String args[]) {
        BinaryTree bTree = new BinaryTree();
        Node root = null;
        root = bTree.addNode(root, 10);
        root = bTree.addNode(root, 20);
        root = bTree.addNode(root, 30);
        root = bTree.addNode(root, 15);
        root = bTree.addNode(root, -10);
        root = bTree.addNode(root, 0);
        root = bTree.addNode(root, 5);
        root = bTree.addNode(root, -5);
        root = bTree.addNode(root, 27);
        new PrintNodesLevelByLevel().printLevelByLevel(root);
    }
}
