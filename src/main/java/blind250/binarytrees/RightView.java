package blind250.binarytrees;

import java.util.ArrayList;

// Node Structure
class RightViewNode {
    int data;
    RightViewNode left, right;

    RightViewNode(int x) {
        data = x;
        left = right = null;
    }
}

class RightView {

    // function for the right view using Recursion
    static void recRightView(RightViewNode root, int level,
                             int[] maxLevel, ArrayList<Integer> result) {
        if (root == null) return;

        // If current level is more than max level,
        // this is the first node of that level
        if (level > maxLevel[0]) {
            result.add(root.data);
            maxLevel[0] = level;
        }

        // Traverse right subtree first, then left subtree
        recRightView(root.right, level + 1,
                maxLevel, result);
        recRightView(root.left, level + 1,
                maxLevel, result);
    }

    // Function to return the right view of the binary tree
    static ArrayList<Integer> rightView(RightViewNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] maxLevel = new int[] {-1};

        // Start recursion with root at level 0
        recRightView(root, 0, maxLevel, result);

        return result;
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //         1
        //        / \
        //       2   3
        //           / \
        //          4   5
        RightViewNode root = new RightViewNode(1);
        root.left = new RightViewNode(2);
        root.right = new RightViewNode(3);
        root.right.left = new RightViewNode(4);
        root.right.right = new RightViewNode(5);

        ArrayList<Integer> result = rightView(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}