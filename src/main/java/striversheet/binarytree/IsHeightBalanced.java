package striversheet.binarytree;

// Node class to represent a node in a binary tree
class IsHeightBalancedNode {
    int data;       // Data stored in the node
    IsHeightBalancedNode left;      // Pointer to the left child
    IsHeightBalancedNode right;     // Pointer to the right child

    // Constructor to initialize the node with a value
    IsHeightBalancedNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class IsHeightBalancedNodeSolution {
    // Function to check if a binary tree is balanced
    public boolean isBalanced(IsHeightBalancedNode root) {
        // If the tree is empty, it's balanced
        if (root == null) {
            return true;
        }

        // Calculate the height of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the absolute difference in heights of left and right subtrees is <= 1
        if (Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(root.left) &&  // Recursively check the left subtree
                isBalanced(root.right)) { // Recursively check the right subtree
            return true;
        }

        // If any condition fails, the tree is unbalanced
        return false;
    }

    // Function to calculate the height of a subtree
    public int getHeight(IsHeightBalancedNode root) {
        // Base case: if the current node is NULL, return 0 (height of an empty tree)
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Return the maximum height of left and right subtrees plus 1 (for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// Main class to test the Solution class
 class IsHeightBalancedNodeMain {
    public static void main(String[] args) {
        // Creating a sample binary tree
        IsHeightBalancedNode root = new IsHeightBalancedNode(1);
        root.left = new IsHeightBalancedNode(2);
        root.right = new IsHeightBalancedNode(3);
        root.left.left = new IsHeightBalancedNode(4);
        root.left.right = new IsHeightBalancedNode(5);
        root.left.right.right = new IsHeightBalancedNode(6);
        root.left.right.right.right = new IsHeightBalancedNode(7);

        // Creating an instance of the Solution class
        IsHeightBalancedNodeSolution solution = new IsHeightBalancedNodeSolution();

        // Checking if the tree is balanced
        if (solution.isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}

