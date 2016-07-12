package com.interviews.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuhinmandal on 11/07/16.
 * <p/>
 * This class find the path from root to leaf node
 * where a give sum exists.
 * we pass sum, compare that with root and then pass (sum - root) to its either left or right till we reach leaf nodes.
 * we do the same for each node and it return true in whatever path the sum exist and adds that path (each node in that
 * path)from leaf to an arraylist.
 * <p/>
 * time complexity is O(n) as we need to visit each node
 */
public class RootToLeafSum {


    public static void main(String args[]) {

        BinaryTree bTree = new BinaryTree();
        Node root = null;
        root = bTree.addNode(root, 10);
        root = bTree.addNode(root, 15);
        root = bTree.addNode(root, 5);
        root = bTree.addNode(root, 7);
        root = bTree.addNode(root, 19);
        root = bTree.addNode(root, 20);
        root = bTree.addNode(root, 20);
        root = bTree.addNode(root, 4);
        root = bTree.addNode(root, 3);


        List<Integer> result = new ArrayList<Integer>();
        boolean hasSumInThePath = new RootToLeafSum().rootToLeafSumFinder(root, 22, result);
        System.out.println("hasSumInThePath ? " + hasSumInThePath);
        if (hasSumInThePath == true && result != null && result.size() > 0) {
            for (Integer data : result) {
                System.out.print(data + " ");
            }
        }
    }

    /**
     * To find a path for a given sum we do the following steps :
     * 1. if root is the only node we compare that value with sum, if both are same returns true else false
     * 2. if root has children we first subtract sum from the root and pass it onto the left , when there is no
     * more children , that is when program reaches leaf node it compares the passed sum to its data (node)
     * and if they match program returns true to the calling function adding the node data to the result list.
     * 3. do the same for the right subtree.
     *
     * @param root
     * @param sum
     * @param result
     * @return
     */
    public boolean rootToLeafSumFinder(Node root, int sum, List<Integer> result) {

        if (root == null) {
            return false;
        }

        // check for the leaf nodes
        if (root.left == null && root.right == null) {
            // now check if data and the sum is same or not
            if (root.data == sum) {
                result.add(root.data);
                return true;
            }
        }

        // check the same recursively in the left subtree
        if (rootToLeafSumFinder(root.left, sum - root.data, result)) {
            result.add(root.data);
            return true;
        }

        // check the same recursively in the right subtree

        if (rootToLeafSumFinder(root.right, sum - root.data, result)) {
            result.add(root.data);
            return true;
        }

        return false;
    }
}
