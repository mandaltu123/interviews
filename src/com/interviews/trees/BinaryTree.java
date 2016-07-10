package com.interviews.trees;

/**
 * Created by tuhinmandal on 10/07/16.
 */

import com.sun.source.tree.Tree;

/**
 * Node class represents each node in a binary tree.
 * Each node has got 3 elements in it, left, right and data.
 */

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

/**
 * Implementation of a binary tree.
 * Binary tree insertion are done here based on binary search tree property:
 * if the data to be inserted is less than current node, it goes to left
 * else goes to right
 */
public class BinaryTree {

    public Node addNode(Node root, int data) {

        Node previous = null; // parent node where the new node to be inserted
        Node current = root;
        Node toBeInserted = new Node(data);

        if (root == null) {
            root = toBeInserted;
            return root;
        }
        //This loop finds the node where the new node
        //to be inserted. But we are yet to say whether
        // new node will go to the left or right
        while (current != null) {
            previous = current;
            if (data > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }


        if (data > previous.data) {
            previous.right = toBeInserted;
        } else {
            previous.left = toBeInserted;
        }

        return root;
    }

    /**
     * Height of a binary tree
     * Idea is : check the left height
     * check right height
     * whichever is max , add 1 to that and then return
     *
     * @param root
     * @return: returns height of the tree
     */
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
