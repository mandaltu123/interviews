package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 13/07/16.
 */
public class IsBinaryTreeBST {

    /**
     * We define an integer min and max range which is Integer.MIN_VALUE and Integer.MAX_VALUE.
     * each time we go left we change the range to Integer.MIN_VALUE to current node
     * and while going right it is current node & Integer.MAX_VALUE.
     * We compare if the current node is within it's own range which is been
     * passed to it from its parent. if all the nodes are withing it's own range
     * it returns true, and that shows the tree is a BST otherwise not.
     * <p/>
     * Time complexity is O(n) as we have to visit all the nodes.
     *
     * @param root
     * @param min  : initially Integer.MIN_VALUE
     * @param max  : initially Integer.MAX_VALUE
     * @return
     */
    public boolean isBST(Node root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data > max) {
            return false;
        }

        return (isBST(root.left, min, root.data) && isBST(root.right, root.data, max));
    }

    public static void main(String args[]) {
        IsBinaryTreeBST isBinaryTreeBST = new IsBinaryTreeBST();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        BinaryTree bTree = new BinaryTree();
        Node root = null;
        root = bTree.addNode(root, 10);
        root = bTree.addNode(root, 20);
        root = bTree.addNode(root, 30);
        root = bTree.addNode(root, 25);
        root = bTree.addNode(root, 0);
        root = bTree.addNode(root, 5);
        root = bTree.addNode(root, 36);
        boolean isBst = isBinaryTreeBST.isBST(root, min, max);
        System.out.print("isBst ? " + isBst);
    }

}
