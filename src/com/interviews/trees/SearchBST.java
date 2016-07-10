package com.interviews.trees;

/**
 * Created by tuhinmandal on 10/07/16.
 */
public class SearchBST {

    public Node search(Node root, int key) {

        if (root == null) {
            return null;
        }
        if (root.data == key) {
            return root;
        } else if (key > root.data) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }

    }

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
        Node searchedNode = new SearchBST().search(root, 30);
        System.out.println("searchedNode = " + searchedNode.data);
    }
}
