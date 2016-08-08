package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 15/07/16.
 * <p/>
 * <p/>
 * AVL tree is a self balancing BST.It has property that
 * at any given node, difference between height of left and right subtree can not be
 * more than 1.
 * <p/>
 * Steps to insert and balance :
 * we insert new node into the AVL tree and keep updating the height of each node
 * that it has traveresed.
 * At each node we keep checking whether the difference remained less than or equal
 * 1 or not. Each time the difference becomes greater than 1, we have to make a rotation
 * either left, or right to adjust height.
 * <p/>
 * There are 4 ways we do this adjustment :
 * <p/>
 * LL:- one right rotation
 * LR:- one left then one right rotation
 * RR:- one left rotation
 * RL:- one right then one left rotation
 */
public class AVLTree {


    public Node insertAVL(Node root, int data) {

        //Insertion same as inserting into BST
        if (root == null) {
            Node newNode = new Node(data);
            return newNode;
        }

        if (data > root.data) {
            root.right = insertAVL(root.right, data);
        } else {
            root.left = insertAVL(root.left, data);
        }

        //Check new height difference in left and right subtree
        int heightDifference = heightDifference(root.left, root.right);

        // Now if after insertion tree has become un balanced, we have to balance them
        if (heightDifference > 1) {
            if (height(root.left.left) >= height(root.left.right)) { //CASE LL
                root = rotateRight(root);
            } else {                                                //CASE LR
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
            }
        } else if (heightDifference < 1) {
            if (height(root.right.right) >= height(root.right.left)) { //CASE RR
                root = rotateLeft(root);
            } else {                                                  // CASE RL
                root.right = rotateRight(root);
                root = rotateLeft(root);
            }

        } else {
            root.height = setHeight(root);
        }

        return root;

    }

    /**
     * left and right rotation is referenced from : geeks for geeks
     * http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
     * @param y
     * @return
     */
    // A utility function to right rotate subtree rooted with y

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    private int setHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(root.left != null ? root.left.height : 0, root.right != null ? root.right.height : 0);
    }

    private int heightDifference(Node left, Node right) {
        return height(left) - height(right);
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.height;
        }
    }



    public static void main(String args[]) {
        AVLTree avlTree = new AVLTree();
        Node root = null;
        root = avlTree.insertAVL(root, 10);
        root = avlTree.insertAVL(root, 20);
        root = avlTree.insertAVL(root, 30);
        root = avlTree.insertAVL(root, 40);
        root = avlTree.insertAVL(root, 50);
        root = avlTree.insertAVL(root, 25);

        TreeTraversals treeTraversals = new TreeTraversals();
        treeTraversals.preOrderTraversal(root);
        //output : 30 20 25 20 25
    }


}
