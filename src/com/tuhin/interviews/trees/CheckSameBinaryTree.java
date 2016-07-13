package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 10/07/16.
 * This class will check whether given two binary trees are same or not
 */
public class CheckSameBinaryTree {


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


        BinaryTree bTree1 = new BinaryTree();
        Node root1 = null;
        root1 = bTree.addNode(root1, 10);
        root1 = bTree.addNode(root1, 20);
        root1 = bTree.addNode(root1, 30);
        root1 = bTree.addNode(root1, 25);
        root1 = bTree.addNode(root1, 0);
        root1 = bTree.addNode(root1, 5);
        root1 = bTree.addNode(root1, 36);
        // root1 = bTree.addNode(root1, 38); if we enable this line, the code will return false since two
        // trees will no longer be the same

        System.out.println("whether they are same or not ? : " + new CheckSameBinaryTree().sameTree(root, root1));
    }


    /**
     * we compare root of each tree and then check their left children and right children.
     * if at each node roots are same and the children are same true is returned else false
     * is returned.
     * time complexity is O(n) since we are visiting all the nodes and comparing them.
     *
     * @param root1
     * @param root2
     * @return true if both trees are same, false if they are not same.
     */
    public boolean sameTree(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.data == root2.data
                && sameTree(root1.left, root2.left)
                && sameTree(root1.right, root2.right));
    }
}
