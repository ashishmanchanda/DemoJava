package DataStructuresPractice.bst;

// Java program to check if a tree is BST

class Node {
    int data;
    FlattenBSToListImpl left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class GfG {

    // Helper function to check if a tree is BST within a given range
    static boolean isBSTUtil(FlattenBSToListImpl node, int min, int max) {
        if (node == null) return true;

        // If the current node's data
        // is not in the valid range, return false
        if (node.data < min || node.data > max) return false;

        // Recursively check the left and
        // right subtrees with updated ranges
        return isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max);
    }

    // Function to check if the entire binary tree is a BST
    static boolean isBST(FlattenBSToListImpl root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        // Create a sample binary tree
        //      4
        //    /   \
        //   2     5
        //  / \
        // 1   3
        FlattenBSToListImpl root = new FlattenBSToListImpl(4);
        root.left = new FlattenBSToListImpl(2);
        root.right = new FlattenBSToListImpl(5);
        root.left.left = new FlattenBSToListImpl(1);
        root.left.right = new FlattenBSToListImpl(3);

        if (isBST(root)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}