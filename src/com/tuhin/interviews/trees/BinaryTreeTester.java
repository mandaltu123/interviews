package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 10/07/16.
 */
public class BinaryTreeTester {
    public static void main(String args[]) {
        BinaryTree bTree = new BinaryTree();
        Node root = null;
        root = bTree.addNode(root, 10);
        root = bTree.addNode(root, 20);
        root = bTree.addNode(root, 30);
        root = bTree.addNode(root, 25);
        root = bTree.addNode(root, 0);
        root = bTree.addNode(root, 5);
        root = bTree.addNode(root, 36);

        System.out.println(bTree.height(root));
    }
}

