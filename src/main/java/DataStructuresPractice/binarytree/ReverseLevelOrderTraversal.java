package DataStructuresPractice.binarytree;

// A recursive Java program to print
// reverse level order traversal
class ReverseLevelOrderTraversal {
    int data;
    ReverseLevelOrderTraversal left, right;

    ReverseLevelOrderTraversal(int x) {
        data = x;
        left = right = null;
    }
}

class ReverseLevelOrderTraversalImpl {

    // Function to find the height of the tree.
    static int height(ReverseLevelOrderTraversal node) {
        if (node == null)
            return 0;

        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight, rheight) + 1;
    }

    // Print nodes at a given level
    static void printGivenLevel(ReverseLevelOrderTraversal root, int nodeLevel, int reqLevel) {
        if (root == null)
            return;

        // if the required level is reached, print the node.
        if (nodeLevel == reqLevel)
            System.out.print(root.data + " ");

            // else call function for left and right subtree.
        else if (nodeLevel < reqLevel) {
            printGivenLevel(root.left, nodeLevel + 1, reqLevel);
            printGivenLevel(root.right, nodeLevel + 1, reqLevel);
        }
    }

    // Function to print REVERSE level order traversal of a tree
    static void reverseLevelOrder(ReverseLevelOrderTraversal root) {
        // find the height of the tree.
        int h = height(root);

        // Start printing from the lowest level.
        for (int i = h; i >= 1; i--)
            printGivenLevel(root, 1, i);
    }

    public static void main(String[] args) {

        // create hard coded tree
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        ReverseLevelOrderTraversal root = new ReverseLevelOrderTraversal(1);
        root.left = new ReverseLevelOrderTraversal(2);
        root.right = new ReverseLevelOrderTraversal(3);
        root.left.left = new ReverseLevelOrderTraversal(4);
        root.left.right = new ReverseLevelOrderTraversal(5);

        reverseLevelOrder(root);
    }
}
