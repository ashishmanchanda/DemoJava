package striversheet.binarytree;

// Node structure for
// the binary tree
class Node {
    int data;
    MaximumDepthNode left;
    MaximumDepthNode right;

    // Constructor to initialize
    // the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Solution class to perform preorder traversal
class MaxPathSolution {

    // Function to perform preorder traversal
    // of the tree and store values in 'arr'
    public void preorder(MaximumDepthNode root, java.util.List<Integer> arr) {
        // If the current node is NULL
        // (base case for recursion), return
        if (root == null) {
            return;
        }
        // Push the current node's
        // value into the vector
        arr.add(root.data);
        // Recursively traverse
        // the left subtree
        preorder(root.left, arr);
        // Recursively traverse
        // the right subtree
        preorder(root.right, arr);
    }

    // Function to initiate preorder traversal
    // and return the resulting list
    public java.util.List<Integer> preOrder(MaximumDepthNode root) {
        // Create an empty list to
        // store preorder traversal values
        java.util.List<Integer> arr = new java.util.ArrayList<>();
        // Call the preorder traversal function
        preorder(root, arr);
        // Return the resulting list
        // containing preorder traversal values
        return arr;
    }
}

// Main class
class Main {
    public static void main(String[] args) {

        // Creating a sample binary tree
        MaximumDepthNode root = new MaximumDepthNode(1);
        root.left = new MaximumDepthNode(2);
        root.right = new MaximumDepthNode(3);
        root.left.left = new MaximumDepthNode(4);
        root.left.right = new MaximumDepthNode(5);

        // Getting preorder traversal
        MaxPathSolution sol = new MaxPathSolution();
        java.util.List<Integer> result = sol.preOrder(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

