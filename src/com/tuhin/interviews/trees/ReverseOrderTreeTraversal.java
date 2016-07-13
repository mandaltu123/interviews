package com.tuhin.interviews.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tuhinmandal on 13/07/16.
 * <p/>
 * We need to print nodes in reverse order.
 * leaf nodes will be printed first till root node.
 */
public class ReverseOrderTreeTraversal {


    /**
     * This is a very simple problem to solve.
     * <p/>
     * We already know level order traversal. In that we initially push root to a queue.
     * then keep popping up data from that queue & print that data. if popped data has left
     * or right children we push it to the queue and keep doing this till the time queue is
     * empty.
     * <p/>
     * the above statements are for level order traversal.in order to print the nodes in reverse order
     * (from leaf to root) all we need is another stack. each time we pop a node from the queue , we need
     * to add that into a stack.
     * Once the queue is empty, the stack will have all the nodes of the tree.
     * Now all we need is pop them one by one, we will have our tree traversal in a reversal order.
     * <p/>
     * <p/>
     * Time complexity O(n) , space complexity is O(n) as at worst case the stack / queue will have
     * all the leaf nodes in it.
     *
     * @param root
     */
    public void reversedLevelOrderTraversal(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root != null) {
                stack.push(root);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
        }

        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.data + " ");
        }

    }

    public static void main(String args[]) {

        BinaryTree bTree = new BinaryTree();
        Node root = null;
        root = bTree.addNode(root, 10);
        root = bTree.addNode(root, 20);
        root = bTree.addNode(root, 30);
        root = bTree.addNode(root, 5);
        root = bTree.addNode(root, -10);
        root = bTree.addNode(root, 20);
        root = bTree.addNode(root, -20);
        root = bTree.addNode(root, -4);
        root = bTree.addNode(root, 25);

        new ReverseOrderTreeTraversal().reversedLevelOrderTraversal(root);
    }
}
