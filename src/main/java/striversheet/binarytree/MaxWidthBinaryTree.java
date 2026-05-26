package striversheet.binarytree;

import java.util.*;

// Class definition for binary tree node
class MaxWidthBinaryTreeNode {
    int val;
    MaxWidthBinaryTreeNode left;
    MaxWidthBinaryTreeNode right;

    // Constructor
    MaxWidthBinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair<K,V>{

    K key;
    V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value=value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// Class containing the method
class MaxWidthBinaryTreeNodeSolution {
    // Function to find the maximum width of binary tree
    public int widthOfBinaryTree(MaxWidthBinaryTreeNode root) {

        // If the root is null, return 0
        if (root == null)
            return 0;

        // Initialize max width
        int maxWidth = 0;

        // Queue to store node and its index
        Queue<Pair<MaxWidthBinaryTreeNode, Integer>> q = new LinkedList<>();

        // Push root with index 0
        q.offer(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {

            // Get size of current level
            int size = q.size();

            // Get the minimum index at this level
            int minIndex = q.peek().getValue();

            // Variables to store first and last index
            int first = 0, last = 0;

            // Traverse all nodes in this level
            for (int i = 0; i < size; i++) {

                // Get current node and index
                Pair<MaxWidthBinaryTreeNode, Integer> p = q.poll();
                MaxWidthBinaryTreeNode node = p.getKey();
                int currIndex = p.getValue() - minIndex;

                // Update first index
                if (i == 0)
                    first = currIndex;

                // Update last index
                if (i == size - 1)
                    last = currIndex;

                // Push left child if exists
                if (node.left != null)
                    q.offer(new Pair<>(node.left,
                            2 * currIndex + 1));

                // Push right child if exists
                if (node.right != null)
                    q.offer(new Pair<>(node.right,
                            2 * currIndex + 2));
            }

            // Update maximum width
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        // Return the final result
        return maxWidth;
    }
}

// Driver class
 class MaxWidthBinaryTreeNodeMain {
    public static void main(String[] args) {

        // Create the tree
        MaxWidthBinaryTreeNode root = new MaxWidthBinaryTreeNode(1);
        root.left = new MaxWidthBinaryTreeNode(3);
        root.right = new MaxWidthBinaryTreeNode(2);
        root.left.left = new MaxWidthBinaryTreeNode(5);
        root.left.right = new MaxWidthBinaryTreeNode(3);
        root.right.right = new MaxWidthBinaryTreeNode(9);

        // Create solution object
        MaxWidthBinaryTreeNodeSolution sol = new MaxWidthBinaryTreeNodeSolution();

        // Call the function and print result
        System.out.println("Maximum width: " +
                sol.widthOfBinaryTree(root));
    }
}
