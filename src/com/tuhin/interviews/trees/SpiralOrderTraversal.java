package com.tuhin.interviews.trees;

import java.util.Stack;

/**
 * Created by tuhinmandal on 13/07/16.
 */
public class SpiralOrderTraversal {

    /**
     * This problem is similar to level order traversal except the fact that we have to print
     * the nodes in a slightly different manner.
     * <p/>
     * One solution is to use 2 stacks.
     * <p/>
     * we take two stacks and add root node to first stack.
     * we remain in a while loop till either of them is non empty.
     * <p/>
     * we pop element from stack1, print it, push it's left and right children to stack 2.
     * we pop element from stack2, print it, push it's right and left children to stack 1.
     * <p/>
     * Key thing to remember: while inserting in stack2 we push right then left. in case of
     * stack 1 we push left then right.
     * <p/>
     * Time complexity O(n) space complexity is O(n) since in worst case both the stacks
     * may be filled with all the leaf nodes.
     *
     * @param root
     */
    public void spiralOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.add(root);

        // stay in the loop as long as both the stacks are not empty

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            //keep popping from stack1 till it becomes empty
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    stack2.push(root.left);
                }
                if (root.right != null) {
                    stack2.push(root.right);
                }
            }

            //keep popping elements from stack 2 till it becomes empty
            while (!stack2.isEmpty()) {
                root = stack2.pop();
                System.out.print(root.data + " ");
                if (root.right != null) {
                    stack1.push(root.right);
                }
                if (root.left != null) {
                    stack1.push(root.left);
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
        root = bTree.addNode(root, 5);
        root = bTree.addNode(root, -10);
        root = bTree.addNode(root, -20);
        root = bTree.addNode(root, -4);
        root = bTree.addNode(root, 25);

        new SpiralOrderTraversal().spiralOrderTraversal(root);
    }
}
