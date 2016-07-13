package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 10/07/16.
 */
public class SearchBST {

    /**
     * Search is a recursive function.
     * It takes 2 parameters root and key. Key is the element that we are trying to
     * search in the BST.
     * since it is a binary tree, we know that the left child is always less than the
     * parent and right is always greater.
     * In this recursive function:
     * 1. we go to root.
     * 2. if key is greater than root, we go to right else go left
     * 3. when the key == current node's data we return that node [this is the node we are trying to search]
     * time complexity is log(n) for balanced binary search tree but O(n) in case unbalanced as in that case
     * we may need to visit all the nodes
     * @param root
     * @param key
     * @return
     */
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
