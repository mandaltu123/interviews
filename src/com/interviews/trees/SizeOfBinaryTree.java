package com.interviews.trees;

/**
 * Created by tuhinmandal on 10/07/16.
 * <p/>
 * this class measures size of  given binary tree.
 */
public class SizeOfBinaryTree {


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
        System.out.print("size is : " + new SizeOfBinaryTree().size(root));
    }

    /**
     * size of binary tree is total number of nodes in that tree.
     * we calculate no of nodes in left subtree, right subtree and add 1 for the root node.
     * that is total size
     * time complexity is O(n) since we have to visit all the nodes
     *
     * @param root
     * @return size
     */
    public int size(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return (leftSize + rightSize + 1);
    }

}
