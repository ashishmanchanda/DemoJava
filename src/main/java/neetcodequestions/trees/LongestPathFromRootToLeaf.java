package neetcodequestions.trees;

// Java implementation to find the sum of nodes
// on the longest path from root to leaf node
// using level order traversal

import java.util.LinkedList;
import java.util.Queue;

class LongestPathNode {
    int data;
    LongestPathNode left, right;

    LongestPathNode(int x) {
        data = x;
        left = right = null;
    }
}

class Longestpathgfg {

    // Function to calculate the sum of the longest
    // root to leaf path using level order traversal
    static int sumOfLongRootToLeafPath(LongestPathNode root) {
        // Base case: if the tree is empty
        if (root == null) return 0;

        // Initialize variables to store
        // maximum length and sum
        int maxSum = 0;
        int maxLen = 0;

        // Queue for level order traversal
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, root.data, 1});

        while (!queue.isEmpty()) {
            Object[] front = queue.poll();
            LongestPathNode node = (LongestPathNode) front[0];
            int sum = (int) front[1];
            int len = (int) front[2];

            // If it's a leaf node, check if we need to
            // update maxLen and maxSum
            if (node.left == null && node.right == null) {
                if (len > maxLen) {
                    maxLen = len;
                    maxSum = sum;
                } else if (len == maxLen && sum > maxSum) {
                    maxSum = sum;
                }
            }

            // Push left and right children into the queue
            if (node.left != null) {
                queue.add(new Object[]
                        {node.left, sum + node.left.data, len + 1});
            }
            if (node.right != null) {
                queue.add(new Object[]
                        {node.right, sum + node.right.data, len + 1});
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        // binary tree formation
        //        4
        //       / \
        //      2   5
        //     / \
        //    1  3
        LongestPathNode root = new LongestPathNode(4);
        root.left = new LongestPathNode(2);
        root.right = new LongestPathNode(5);
        root.left.left = new LongestPathNode(1);
        root.left.right = new LongestPathNode(3);


        System.out.println(sumOfLongRootToLeafPath(root));
    }
}
