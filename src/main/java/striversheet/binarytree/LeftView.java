package striversheet.binarytree;

import java.util.ArrayList;

// Node Structure
class LeftViewNode {
    int data;
    LeftViewNode left, right;

    LeftViewNode(int x) {
        data = x;
        left = right = null;
    }
}

class GFG {

    // Recursive function to find left view
    static void recLeftView(LeftViewNode root, int level, ArrayList<Integer> result) {
        if (root == null) return;

        // first node of current level
        if (level == result.size()) {
            result.add(root.data);
        }

        recLeftView(root.left, level + 1, result);
        recLeftView(root.right, level + 1, result);
    }

    // Function which return left view of binary tree
    static ArrayList<Integer> leftView(LeftViewNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        recLeftView(root, 0, result);
        return result;
    }

    public static void main(String[] args) {

        // Create binary tree
        //    1
        //   / \
        //  2   3
        //     /
        //    4
        //     \
        //      5

        LeftViewNode root = new LeftViewNode(1);
        root.left = new LeftViewNode(2);
        root.right = new LeftViewNode(3);
        root.right.left = new LeftViewNode(4);
        root.right.left.right = new LeftViewNode(5);

        ArrayList<Integer> view = leftView(root);
        for (int val : view)
            System.out.print(val + " ");

    }
}