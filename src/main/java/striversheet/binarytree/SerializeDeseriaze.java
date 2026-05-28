package striversheet.binarytree;

import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize node value and child pointers
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class SDSolution {

    // Function to serialize a binary tree into a string using level-order traversal
    public String serialize(TreeNode root) {

        // If tree is empty, return an empty string
        if (root == null) return "";

        // Initialize string to store serialized result
        StringBuilder s = new StringBuilder();

        // Initialize a queue to store nodes during level-order traversal
        Queue<TreeNode> q = new LinkedList<>();

        // Push root node into the queue
        q.offer(root);

        // Loop while queue is not empty
        while (!q.isEmpty()) {

            // Get the current node from the front of the queue
            TreeNode curNode = q.poll();

            // If current node is null, append "#" to string
            if (curNode == null) {
                s.append("#,");
            } else {
                // Append node value to string
                s.append(curNode.val).append(",");

                // Push left child into queue
                q.offer(curNode.left);

                // Push right child into queue
                q.offer(curNode.right);
            }
        }

        // Return the serialized tree string
        return s.toString();
    }

    // Function to deserialize a string and reconstruct the binary tree
    public TreeNode deserialize(String data) {

        // If data is empty, return null
        if (data.isEmpty()) return null;

        // Use string splitting to parse the input data
        String[] values = data.split(",");

        // Create the root node
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // Initialize a queue to hold tree nodes for level-order reconstruction
        Queue<TreeNode> q = new LinkedList<>();

        // Push root node into the queue
        q.offer(root);

        // Index for navigating the value array
        int i = 1;

        // Loop through the array to construct the tree
        while (!q.isEmpty() && i < values.length) {

            // Get the current node from the front of the queue
            TreeNode node = q.poll();

            // Read the left child value
            if (!values[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            i++;

            // Read the right child value
            if (!values[i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightNode;
                q.offer(rightNode);
            }
            i++;
        }

        // Return the root of the reconstructed tree
        return root;
    }

    // Function to perform in-order traversal and print the tree
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

// Driver code
class SDMain {
    public static void main(String[] args) {

        // Manually construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Create an instance of the SDSolution class
        SDSolution SDSolution = new SDSolution();

        // Print original tree using in-order traversal
        System.out.print("Orignal Tree: ");
        SDSolution.inorder(root);
        System.out.println();

        // Serialize the tree into a string
        String serialized = SDSolution.serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize the string back into a tree
        TreeNode deserialized = SDSolution.deserialize(serialized);

        // Print tree after deserialization
        System.out.print("Tree after deserialisation: ");
        SDSolution.inorder(deserialized);
        System.out.println();
    }
}

