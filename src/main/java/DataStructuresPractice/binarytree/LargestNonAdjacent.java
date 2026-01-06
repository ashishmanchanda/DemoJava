package DataStructuresPractice.binarytree;

// Java program to find the maximum sum
// of non-adjacent nodes in a binary tree.

class LargestNonAdacent {
    int data;
    LargestNonAdacent left, right;

    LargestNonAdacent(int x) {
        data = x;
        left = right = null;
    }
}

class LargestNonAdacentImpl {

    // Utility method to return the maximum sum
    // rooted at the node 'node'
    static int getMaxSumUtil(LargestNonAdacent node) {
        if (node == null) {

            // If the node is null, the sum is 0
            return 0;
        }

        // Calculate the maximum sum including
        // the current node
        int incl = node.data;

        // If the left child exists, include its contribution
        if (node.left != null) {
            incl += getMaxSumUtil(node.left.left) +
                    getMaxSumUtil(node.left.right);
        }

        // If the right child exists, include
        // its contribution
        if (node.right != null) {
            incl += getMaxSumUtil(node.right.left) +
                    getMaxSumUtil(node.right.right);
        }

        // Calculate the maximum sum excluding
        // the current node
        int excl = 0;
        if (node.left != null) {
            excl += getMaxSumUtil(node.left);
        }
        if (node.right != null) {
            excl += getMaxSumUtil(node.right);
        }

        // The result for the current node is the
        // maximum of including or excluding it
        return Math.max(incl, excl);
    }

    static int getMaxSum(LargestNonAdacent root) {

        // If the tree is empty, the maximum sum is 0
        if (root == null) {
            return 0;
        }
        // Call the utility function to compute the
        // maximum sum for the entire tree
        return getMaxSumUtil(root);
    }

    public static void main(String[] args) {

        // Creating a binary tree with the following structure:
        //          1
        //         / \
        //        2   3
        //       /   / \
        //      1   4   5
        LargestNonAdacent root = new LargestNonAdacent(1);
        root.left = new LargestNonAdacent(2);
        root.right = new LargestNonAdacent(3);
        root.right.left = new LargestNonAdacent(4);
        root.right.right = new LargestNonAdacent(5);
        root.left.left = new LargestNonAdacent(1);

        System.out.println(getMaxSum(root));
    }
}

