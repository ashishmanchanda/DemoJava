package DataStructuresPractice.binarytree;

// Java program to find the height of a binary
// tree using depth-first search (DFS) approach.

class HeightBinaryTree {
    int data;
    HeightBinaryTree left, right;

    HeightBinaryTree(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class HeightBinaryTreeImpl {

    // Returns height which is the number of edges
    // along the longest path from the root node down
    // to the farthest leaf node.
    static int height(HeightBinaryTree root) {
        if (root == null)
            return -1;

        // compute the height of left and right subtrees
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        HeightBinaryTree root = new HeightBinaryTree(1);
        root.left = new HeightBinaryTree(2);
        root.right = new HeightBinaryTree(3);
        root.left.left = new HeightBinaryTree(4);
        root.left.right = new HeightBinaryTree(5);

        System.out.println(height(root));
    }
}