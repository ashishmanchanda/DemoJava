package blind250.binarytrees;

import java.util.ArrayList;

//Node Structure
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int v) {
        data = v;
        left = right = null;
    }
}

class GFG {

    public static void preOrder(TreeNode node, ArrayList<Integer> res) {
        if (node == null)
            return;

        // Visit the current node first
        res.add(node.data);

        // Traverse the left subtree
        preOrder(node.left, res);

        // Traverse the right subtree
        preOrder(node.right, res);
    }

    public static void main(String[] args) {
        // Create binary tree
        //       1
        //      /  \
        //    2     3
        //   / \     \
        //  4   5     6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}