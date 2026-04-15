package blind250.binarytrees;

// Node Structure
class BalancedTreeNode {
    int data;
    BalancedTreeNode left;
    BalancedTreeNode right;

    BalancedTreeNode(int d) {
        int data = d;
        this.left = null;
        this.right = null;
    }
}

class Balanced {

    // Function to calculate the height of a tree
    static int height(BalancedTreeNode node) {
        if (node == null)
            return 0;

        // Height = 1 + max of left height and right heights
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Function to check if the binary tree with given root
    // is height-balanced
    static boolean isBalanced(BalancedTreeNode root) {
        if (root == null)
            return true;

        // Get the height of left and right sub trees
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (Math.abs(lHeight - rHeight) > 1)
            return false;

        // Recursively check the left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        // Representation of input BST:
        //            10
        //           / \
        //          20   30
        //         /  \
        //        40   60
        BalancedTreeNode root = new BalancedTreeNode(10);
        root.left = new BalancedTreeNode(20);
        root.right = new BalancedTreeNode(30);
        root.left.left = new BalancedTreeNode(40);
        root.left.right = new BalancedTreeNode(60);

        System.out.println(isBalanced(root) ? "true" : "false");
    }
}
