package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 12/07/16.
 * <p/>
 * Given two binary trees check whether both are same or not.
 * This is very simple.In order to do so first we need to check whether the root is same or not, then
 * we have to compare left child and right child whether they are same or different. We have to this
 * recursively for every node.
 * <p/>
 * Time complexity O(n) as we have to visit all the nodes.
 */
public class SameBinaryTree {


    public boolean sameBinaryTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.data == root2.data)
                && (sameBinaryTree(root1.left, root2.left))
                && (sameBinaryTree(root1.right, root2.right));
    }


    public static void main(String args[]) {

        //Tree one
        BinaryTree bTree1 = new BinaryTree();
        Node root1 = null;
        root1 = bTree1.addNode(root1, 10);
        root1 = bTree1.addNode(root1, 20);
        root1 = bTree1.addNode(root1, 30);
        root1 = bTree1.addNode(root1, 25);
        root1 = bTree1.addNode(root1, 0);
        root1 = bTree1.addNode(root1, 5);
        root1 = bTree1.addNode(root1, 36);

        //Tree 2
        BinaryTree bTree2 = new BinaryTree();
        Node root2 = null;
        root2 = bTree2.addNode(root2, 10);
        root2 = bTree2.addNode(root2, 20);
        root2 = bTree2.addNode(root2, 30);
        root2 = bTree2.addNode(root2, 25);
        root2 = bTree2.addNode(root2, 0);
        root2 = bTree2.addNode(root2, 5);
        root2 = bTree2.addNode(root2, 36);


        // Tree 3
        BinaryTree bTree3 = new BinaryTree();
        Node root3 = null;
        root3 = bTree3.addNode(root3, 10);
        root3 = bTree3.addNode(root3, 20);
        root3 = bTree3.addNode(root3, 30);
        root3 = bTree3.addNode(root3, 25);

        boolean areSame = new SameBinaryTree().sameBinaryTree(root1, root2);
        System.out.println("areSame ? " + areSame);

        boolean areSameTwoAndThree = new SameBinaryTree().sameBinaryTree(root2, root3);
        System.out.println("areSameTwoAndThree ? " + areSameTwoAndThree);
    }
}
