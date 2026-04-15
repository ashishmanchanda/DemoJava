package blind250.binarytrees;

// Node structure
class SameTreeNode {
    int data;
    SameTreeNode left, right;

    SameTreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class SameTree {

    static boolean isIdentical(SameTreeNode r1, SameTreeNode r2) {

        // If both trees are empty, they are identical
        if (r1 == null && r2 == null)
            return true;

        // If only one tree is empty, they are not identical
        if (r1 == null || r2 == null)
            return false;

        // Check if the root data is the same and
        // recursively check for the left and right subtrees
        return (r1.data == r2.data) &&
                isIdentical(r1.left, r2.left) &&
                isIdentical(r1.right, r2.right);
    }

    public static void main(String[] args) {

        // Representation of input binary tree 1
        //        1
        //       / \
        //      2   3
        //     /
        //    4
        SameTreeNode r1 = new SameTreeNode(1);
        r1.left = new SameTreeNode(2);
        r1.right = new SameTreeNode(3);
        r1.left.left = new SameTreeNode(4);

        // Representation of input binary tree 2
        //        1
        //       / \
        //      2   3
        //     /
        //    4
        SameTreeNode r2 = new SameTreeNode(1);
        r2.left = new SameTreeNode(2);
        r2.right = new SameTreeNode(3);
        r2.left.left = new SameTreeNode(4);

        if (isIdentical(r1, r2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}