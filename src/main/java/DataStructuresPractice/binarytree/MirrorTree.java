package DataStructuresPractice.binarytree;

// Java Program Invert a Binary Tree using Recursive Postorder

class MirrorTree {
    int data;
    MirrorTree left, right;

    MirrorTree(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class MirrorTreeImpl {

    // function to return the root of inverted tree
    static MirrorTree mirror(MirrorTree root) {
        if (root == null)
            return null;

        // Invert the left and right subtree
        MirrorTree left = mirror(root.left);
        MirrorTree right = mirror(root.right);

        // Swap the left and right subtree
        root.left = right;
        root.right = left;

        return root;
    }

    static void inOrder(MirrorTree root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {

        // Input Tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        MirrorTree root = new MirrorTree(1);
        root.left = new MirrorTree(2);
        root.right = new MirrorTree(3);
        root.left.left = new MirrorTree(4);
        root.left.right = new MirrorTree(5);

        root = mirror(root);

        // Mirror Tree:
        //       1
        //      / \
        //     3   2
        //        / \
        //       5   4
        inOrder(root);
    }
}
