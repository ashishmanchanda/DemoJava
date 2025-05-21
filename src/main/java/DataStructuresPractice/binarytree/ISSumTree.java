package DataStructuresPractice.binarytree;

// Java program to check if Binary tree
// is sum tree or not
class IsSumTree {
    int data;
    IsSumTree left, right;

    IsSumTree(int x) {
        data = x;
        left = right = null;
    }
}

class ISSumTreeImpl {

    // Utility function to check if the given node is leaf or not
    static boolean isLeaf(IsSumTree node) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    static boolean isSumTree(IsSumTree root) {
        int ls, rs;

        // If node is null or it's a leaf node then return true
        if (root == null || isLeaf(root))
            return true;

        // If the left subtree and right subtree are sum trees,
        // then we can find subtree sum in O(1).
        if (isSumTree(root.left) && isSumTree(root.right)) {

            // Get the sum of nodes in left subtree
            if (root.left == null)
                ls = 0;
            else if (isLeaf(root.left))
                ls = root.left.data;
            else
                ls = 2 * (root.left.data);

            // Get the sum of nodes in right subtree
            if (root.right == null)
                rs = 0;
            else if (isLeaf(root.right))
                rs = root.right.data;
            else
                rs = 2 * (root.right.data);

            // If root's data is equal to sum of nodes in left
            // and right subtrees then return true else return false
            return root.data == ls + rs;
        }

        // if either of left or right subtree is not
        // sum tree, then return false.
        return false;
    }

    public static void main(String[] args) {

        // create hard coded tree
        //       26
        //      /  \
        //     10   3
        //    / \    \
        //   4  6     3
        IsSumTree root = new IsSumTree(26);
        root.left = new IsSumTree(10);
        root.right = new IsSumTree(3);
        root.left.left = new IsSumTree(4);
        root.left.right = new IsSumTree(6);
        root.right.right = new IsSumTree(3);

        if (isSumTree(root))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
