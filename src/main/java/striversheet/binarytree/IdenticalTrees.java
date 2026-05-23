package striversheet.binarytree;

// Solution class to check if two binary trees are identical
class IdenticalNodeSolution {
    // Function to check if two binary trees are identical
    public boolean isIdentical(IdenticalNode node1, IdenticalNode node2) {
        // Case 1: If both nodes are NULL, they are identical
        if (node1 == null && node2 == null) {
            return true;
        }

        // Case 2: If only one of the nodes is NULL, they are not identical
        if (node1 == null || node2 == null) {
            return false;
        }

        // Check if the current nodes have the same data value
        // and recursively check their left and right subtrees
        return (node1.data == node2.data) &&
                isIdentical(node1.left, node2.left) &&
                isIdentical(node1.right, node2.right);
    }
}

// Node class for the binary tree
class IdenticalNode {
    int data;       // Data stored in the node
    IdenticalNode left;      // Pointer to the left child
    IdenticalNode right;     // Pointer to the right child

    // Constructor to initialize the node with a value
    IdenticalNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Main class to test the Solution class
 class IdenticalNodeMain {
    public static void main(String[] args) {
        // Creating the first binary tree (Node1)
        IdenticalNode root1 = new IdenticalNode(1);
        root1.left = new IdenticalNode(2);
        root1.right = new IdenticalNode(3);
        root1.left.left = new IdenticalNode(4);

        // Creating the second binary tree (Node2)
        IdenticalNode root2 = new IdenticalNode(1);
        root2.left = new IdenticalNode(2);
        root2.right = new IdenticalNode(3);
        root2.left.left = new IdenticalNode(4);

        // Creating an instance of the Solution class
        IdenticalNodeSolution solution = new IdenticalNodeSolution();

        // Check if the two binary trees are identical and output the result
        if (solution.isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}

