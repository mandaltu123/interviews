package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 13/07/16.
 */
public class FindLowestCommonAncestorBST {

    /**
     * This is a very simple problem to solve.
     * A lowest common ancestor is a node for 2 given nodes where both the nodes
     * are descendants of the node.
     * <p/>
     * Now this search is very easy. we know that in a binary search tree, all
     * nodes on the left subtree is less than the root and all nodes in the right
     * subtree are higher than the root node.
     * So for given two nodes we check whether both are greater or less than root.
     * Based on that we either traverse to the left or right and check whether the
     * next child is in between two given nodes. we keep doing this till we fulfill
     * above condition, for whatever node this condition is satisfied that node
     * is the Lowest Common Ancestor of the two input nodes.
     * <p/>
     * Time complexity is O(h) where h:- is the height of the BST
     *
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    public Node lowestCommonAncestor(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }

        if (root.data > Math.max(n1, n2)) {
            return lowestCommonAncestor(root.left, n1, n2);
        } else if (root.data < Math.min(n1, n2)) {
            return lowestCommonAncestor(root.right, n1, n2);
        } else return root;
    }


    public static void main(String args[]) {

        BinaryTree bTree = new BinaryTree();
        Node root = null;
        root = bTree.addNode(root, 10);
        Node n1 = bTree.addNode(root, 20);
        Node n2 = bTree.addNode(root, 30);
        Node n3 = bTree.addNode(root, 5);
        Node n4 = bTree.addNode(root, -10);
        Node n5 = bTree.addNode(root, 20);
        Node n6 = bTree.addNode(root, -20);
        Node n7 = bTree.addNode(root, -4);
        Node n8 = bTree.addNode(root, 25);

        Node lca = new FindLowestCommonAncestorBST().lowestCommonAncestor(root, 20, 25);
        System.out.println("lca of " + 20 + " and " + 25 + " is :- " + lca.data);
        //lca of 20 and 25 is :- 20
    }
}
