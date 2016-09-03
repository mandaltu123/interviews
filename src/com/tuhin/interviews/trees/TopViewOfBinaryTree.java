package com.tuhin.interviews.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Find top view of a binary tree.
 *
 *          1
 *       2      3
 *    4     5 6     7
 *
 *    Top view of the above binary tree is
        4 2 1 3 7


            1
        2       3
            4
                5
                    6

root : 1
 left : 2
 right : 3
 4,5,6 are right children of 2

 top view : 1 2 3 6

 *
 * Reference : geeksforgeeks
 * @author tuhinmandal on 03/09/16.
 */

    // class representing tree node
     class TreeNode {

        int key;
        TreeNode left;
        TreeNode right;
        public TreeNode(int key) {
            this.key = key;
            left = right = null;
        }
    }
    // class represents queue item.this queue is used for level order traversal.
    //Every queue item contains node and horizontal distance of node from root hd
    class QItem {
        TreeNode node;
        int hd;
        public QItem(TreeNode n, int h) {
            node = n;
            hd = h;
        }
    }


    // class for a binary tree top view
    class BinaryTreeTopViewer {
        TreeNode root;
        public BinaryTreeTopViewer() {
            root = null;
        }

        public BinaryTreeTopViewer(TreeNode n) {
            root = n;
        }


        public void topView() {

            //base case
            if(root == null) {
                return;
            }
            // crate an empty hashset
            HashSet<Integer> set = new HashSet<Integer>();
            //for level order traversal create a new queue and add root to it
            Queue<QItem> queue = new LinkedList<QItem>();
            queue.add(new QItem(root, 0));//horizontal distance from root is 0 for root

            //BFS or level order traversal of tree
            while (!queue.isEmpty()) {

                // remove from of the queue
                QItem item = queue.remove();
                int hd = item.hd;
                TreeNode node = item.node;
                // If this is the first node at its horizontal distance,
                // then this node is in top view
                if(!set.contains(hd)) {
                    set.add(hd);
                    System.out.print(node.key + " ");
                }

                if(node.left != null) {
                    queue.add(new QItem(node.left, hd -1));
                }
                if(node.right != null) {
                    queue.add(new QItem(node.right, hd + 1));
                }
            }

        }
    }



public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        BinaryTreeTopViewer t = new BinaryTreeTopViewer(root);
        t.topView();
    }
}


