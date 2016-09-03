package com.tuhin.interviews.trees;

/**
 * MorrisTraversal is useful in case you are not supposed to use any recursion or stack/queue for traversal.
 *
 * @author tuhinmandal on 03/09/16.
 */
public class MorrisTraversal {

    public static void morrisInOrder(Node root) {

        Node current = root;
        while (current != null) {
            //check there exists no left subtree, if it does not exist we can visit current node and move towards right
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            //there is a left subtree.
            else {
                //find predecessor
                Node predecessor = current.left;
                //to find a predecessor, keep going to the right till it is ot null or current
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                //if right node is null go left after establishing link from predecessor to current
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else { // left is already visited. go to right after visiting current
                    predecessor.right = null; // breaking the link between predecessor and current
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }


    public static void morrisPreOrder(Node root) {

        Node current = root;
        while (current != null) {
            //check there exists no left subtree, if it does not exist we can visit current node and move towards right
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            //there is a left subtree.
            else {
                //find predecessor
                Node predecessor = current.left;
                //to find a predecessor, keep going to the right till it is ot null or current
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                //if right node is null go left after establishing link from predecessor to current
                if (predecessor.right == null) {
                    predecessor.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                } else { // left is already visited. go to right after visiting current
                    predecessor.right = null; // breaking the link between predecessor and current
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(root, 10);
        root = bt.addNode(root, 50);
        root = bt.addNode(root, -10);
        root = bt.addNode(root, 7);
        root = bt.addNode(root, 9);
        root = bt.addNode(root, -20);
        root = bt.addNode(root, 30);
        morrisInOrder(root);
        System.out.println();
        morrisPreOrder(root);
    }
}
