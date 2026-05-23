package striversheet.binarytree;


import java.util.LinkedList;
import java.util.Queue;

// Node class for the binary tree
class MaximumDepthNode {
    int data;
    MaximumDepthNode left;
    MaximumDepthNode right;

    // Constructor to initialize
    // the node with a value
    MaximumDepthNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class MaximumDepthSolution {
    // Function to find the
    // maximum depth of a binary tree
    // using level order traversal
    int maxDepth(MaximumDepthNode root) {
        // If the root is NULL
        // (empty tree), depth is 0
        if (root == null) {
            return 0;
        }

        // Create a queue for
        // level order traversal
        Queue<MaximumDepthNode> q = new LinkedList<>();
        int level = 0;

        // Push the root node into the queue
        q.add(root);

        // While there are nodes in the queue
        while (!q.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = q.size();

            // Process all nodes
            // at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                MaximumDepthNode front = q.poll();

                // Enqueue left child if exists
                if (front.left != null) {
                    q.add(front.left);
                }

                // Enqueue right child if exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to
            // move to the next level
            level++;
        }
        // Return the level, which represents
        // the maximum depth of the tree
        return level;
    }
}

// Main class
class MaximumDepthMain {
    // Main function
    public static void main(String[] args) {
        // Creating a sample binary tree
        MaximumDepthNode root = new MaximumDepthNode(1);
        root.left = new MaximumDepthNode(2);
        root.right = new MaximumDepthNode(3);
        root.left.left = new MaximumDepthNode(4);
        root.left.right = new MaximumDepthNode(5);
        root.left.right.right = new MaximumDepthNode(6);
        root.left.right.right.right = new MaximumDepthNode(7);

        MaximumDepthSolution solution = new MaximumDepthSolution();
        int depth = solution.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}

