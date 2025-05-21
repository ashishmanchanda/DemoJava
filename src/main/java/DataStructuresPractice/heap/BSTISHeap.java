package DataStructuresPractice.heap;

// Java Program to Check if a given Binary
// Tree is a Heap

class BSTIsHeap {
    int key;
    BSTIsHeap left;
    BSTIsHeap right;

    BSTIsHeap(int k) {
        key = k;
        left = null;
        right = null;
    }
}

class GfG {

    // This function counts the number of nodes
    // in a binary tree
    static int countNodes(BSTIsHeap root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // This function checks if the binary tree is complete or not
    static boolean isCompleteUtil(BSTIsHeap root, int index, int numberOfNodes) {
        if (root == null)
            return true;

        // If index assigned to current node is more than
        // number of nodes in the tree, then the tree is not complete
        if (index >= numberOfNodes)
            return false;

        // Recur for left and right subtrees
        return isCompleteUtil(root.left, 2 * index + 1, numberOfNodes) &&
                isCompleteUtil(root.right, 2 * index + 2, numberOfNodes);
    }

    // This function checks the heap property in the tree.
    static boolean isHeapUtil(BSTIsHeap root) {
        if (root.left == null && root.right == null)
            return true;

        // Node will be in the second-last level
        if (root.right == null) {

            // Check heap property at the node
            // No recursive call because no need to
            // check the last level
            return root.key >= root.left.key;
        } else {

            // Check heap property at the node and recursively
            // check the heap property at left and right subtrees
            if (root.key >= root.left.key && root.key >= root.right.key)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
        }
    }

    // Function to check if the binary tree is a Heap or not.
    static boolean isHeap(BSTIsHeap root) {
        int nodeCount = countNodes(root);
        int index = 0;

        if (isCompleteUtil(root, index, nodeCount) && isHeapUtil(root))
            return true;
        return false;
    }

    public static void main(String[] args) {

        // Construct the Binary Tree
        //        10
        //       /  \
        //      9    8
        //     / \   / \
        //    7   6 5   4

        BSTIsHeap root = new BSTIsHeap(10);
        root.left = new BSTIsHeap(9);
        root.right = new BSTIsHeap(8);
        root.left.left = new BSTIsHeap(7);
        root.left.right = new BSTIsHeap(6);
        root.right.left = new BSTIsHeap(5);
        root.right.right = new BSTIsHeap(4);

        if (isHeap(root)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
