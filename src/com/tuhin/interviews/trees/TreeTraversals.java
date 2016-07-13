package com.tuhin.interviews.trees;

import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println("\n" + "Level order traversal-------------");
        new TreeTraversals().levelOrderTraversal(root);
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

    /**
     * Level order traversal is Breadth First traversal where we visit each level befor going to the
     * next level.
     * We take one queue and initially insert root to it.
     * then we poll root from the queue , print it and if that root has left or right we insert them into
     * the queue. we keep doing this till the ques is not empty.
     * <p/>
     * <p/>
     * Time complexity is O(n) and space complexity is O(n) as at worst case we fill the queue with n/2 data
     *
     * @param root
     */
    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.data + " ");
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }
}
