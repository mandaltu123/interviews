package com.tuhin.interviews.trees;

/**
 * Created by tuhinmandal on 14/07/16.
 */
public class LowestCommonAncestorBinaryTree {


    /**
     * Lowest common ancestor is the node in a binary tree from where
     * 2 nodes for which we are looking for the lca diverges.
     * To find that we pass root, and to nodes to our method.
     * <p/>
     * First we check on the left side if either of them exists.
     * Any of them found on the left subtree , we return that node
     * to its parent, if not found, we return null. Same way we try to find either of them on the right
     * side. While this traversal if any node receive non null values from it's left and
     * right, we know that is the lowest common ancestor node.
     * <p/>
     * Time complexity is O(n) and space complexity is O(h) where h is the height of
     * the binary tree.
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

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, n1, n2);
        Node right = lowestCommonAncestor(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return left != null ? left : right;
    }

    public static void main(String args[]) {
        // test similar way as we did in the case of binary search tree
    }
}
