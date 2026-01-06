package DataStructuresPractice.binarytree;// Java program to find the diameter
// of a binary tree.

class DiameterOfBinaryTree {
    int data;
    DiameterOfBinaryTree left, right;

    DiameterOfBinaryTree(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class DiameterOfBinaryTreeImpl {

    // Recursive function which finds the
    // height of root and also calculates
    // the diameter of the tree.
    static int diameterRecur(DiameterOfBinaryTree root, int[] ans) {

        // Base case: tree is empty
        if (root == null)
            return 0;

        // find the height of left and right subtree
        // (it will also find of diameter for left
        // and right subtree).
        int lHeight = diameterRecur(root.left, ans);
        int rHeight = diameterRecur(root.right, ans);

        // Check if diameter of root is greater
        // than ans.
        ans[0] = Math.max(ans[0], lHeight + rHeight);

        // return the height of current subtree.
        return 1 + Math.max(lHeight, rHeight);
    }

    // Function to get diameter of a binary tree
    static int diameter(DiameterOfBinaryTree root) {
        int[] ans = new int[1];
        diameterRecur(root, ans);
        return ans[0];
    }

    public static void main(String[] args) {

        // Constructed binary tree is
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        DiameterOfBinaryTree root = new DiameterOfBinaryTree(1);
        root.left = new DiameterOfBinaryTree(2);
        root.right = new DiameterOfBinaryTree(3);
        root.left.left = new DiameterOfBinaryTree(4);
        root.left.right = new DiameterOfBinaryTree(5);

        System.out.println(diameter(root));
    }
}