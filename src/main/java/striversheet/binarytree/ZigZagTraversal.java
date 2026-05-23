package striversheet.binarytree;

import java.util.*;

// Class to represent a binary tree node
class TreeNode {
    int val;              // Value of the node
    TreeNode left;        // Pointer to left child
    TreeNode right;       // Pointer to right child

    // Constructor to initialize node with a given value
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to perform zigzag (spiral) level order traversal of a binary tree
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // List to store the final zigzag traversal result
        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty, return an empty list
        if (root == null) return result;

        // Queue to store nodes for BFS (level order traversal)
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Boolean flag to control traversal direction
        boolean leftToRight = true;

        // Loop until all levels are processed
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();

            // Temporary array to store current level's values in zigzag order
            Integer[] level = new Integer[size];

            // Process each node in the current level
            for (int i = 0; i < size; i++) {
                // Get the front node from the queue
                TreeNode node = q.poll();

                // Determine index where this value should be stored
                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.val;

                // Add left child to queue if it exists
                if (node.left != null) q.offer(node.left);
                // Add right child to queue if it exists
                if (node.right != null) q.offer(node.right);
            }

            // Flip traversal direction for the next level
            leftToRight = !leftToRight;

            // Add current level to the final result
            result.add(Arrays.asList(level));
        }

        // Return the zigzag traversal result
        return result;
    }
}

 class ZigzagMain {
    public static void main(String[] args) {
        // Create binary tree:
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create solution object
        Solution sol = new Solution();

        // Get zigzag traversal
        List<List<Integer>> ans = sol.zigzagLevelOrder(root);

        // Print result
        System.out.println(ans);
    }
}
