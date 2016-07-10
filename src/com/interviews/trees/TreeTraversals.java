package com.interviews.trees;

/**
 * Created by tuhinmandal on 10/07/16.
 * TreeTraversals shows different ways of traversing tree.
 * there are mainly 2 ways to traverse breadth first and depth first.
 */
public class TreeTraversals {



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

        System.out.println("Preorder traversal-------------");
        new TreeTraversals().preOrderTraversal(root);
        System.out.println("\n" + "Inorder traversal-------------");
        new TreeTraversals().inOrderTraversal(root);
        System.out.println("\n" + "Postorder traversal-------------");
        new TreeTraversals().postOrderTraversal(root);
    }

    /**
     * Pre order traversal is a depth first traversal.
     * VLR: visit left right
     * Idea is for a given tree we visit the root first, then visit left child and then right. And we do this
     * recursively for every node
     *
     * @param root
     */
    public void preOrderTraversal(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * In order traversal is also a depth first traversal.
     * LVR: left visit right
     * Idea is for a given node we visit the left child first , then visit the root then go to right. And we do this
     * recursively for every single node
     *
     * @param root
     */
    public void inOrderTraversal(Node root) {

        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    /**
     * post order traversal is again a type of depth first traversal.
     * LRV: left right visit
     * Idea is to visit the left child first, then right then the root. And this is done for all nodes.
     *
     * @param root
     */
    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
