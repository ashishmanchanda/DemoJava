package DataStructuresPractice.binarytree;

// Java code to check if two trees are
// isomorphic using recursion

class IsISoMorphic {
    int data;
    IsISoMorphic left, right;

    IsISoMorphic(int x) {
        data = x;
        left = right = null;
    }
}

class IsISoMorphicImpl {

    // Function to check if two trees are isomorphic
    static boolean isIsomorphic(IsISoMorphic root1, IsISoMorphic root2) {

        // Both roots are NULL, trees are
        // isomorphic by definition
        if (root1 == null && root2 == null) {
            return true;
        }

        // Exactly one of the root1 and root2 is NULL,
        // trees not isomorphic
        if (root1 == null || root2 == null) {
            return false;
        }

        // If the data doesn't match, trees are not isomorphic
        if (root1.data != root2.data) {
            return false;
        }

        // Check if the trees are isomorphic by
        // considering the two cases:
        // Case 1: The subtrees have not been flipped
        // Case 2: The subtrees have been flipped
        return (isIsomorphic(root1.left, root2.left) &&
                isIsomorphic(root1.right, root2.right)) ||
                (isIsomorphic(root1.left, root2.right) &&
                        isIsomorphic(root1.right, root2.left));
    }

    public static void main(String[] args) {

        // Representation of input binary tree 1
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        //       / \
        //      7   8
        IsISoMorphic root1 = new IsISoMorphic(1);
        root1.left = new IsISoMorphic(2);
        root1.right = new IsISoMorphic(3);
        root1.left.left = new IsISoMorphic(4);
        root1.left.right = new IsISoMorphic(5);
        root1.left.right.left = new IsISoMorphic(7);
        root1.left.right.right = new IsISoMorphic(8);

        // Representation of input binary tree 2
        //        1
        //       / \
        //      3   2
        //     /   / \
        //    6   4   5
        //           / \
        //          8   7
        IsISoMorphic root2 = new IsISoMorphic(1);
        root2.left = new IsISoMorphic(3);
        root2.right = new IsISoMorphic(2);
        root2.left.left = new IsISoMorphic(6);
        root2.right.left = new IsISoMorphic(4);
        root2.right.right = new IsISoMorphic(5);
        root2.right.right.left = new IsISoMorphic(8);
        root2.right.right.right = new IsISoMorphic(7);

        if (isIsomorphic(root1, root2)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}
