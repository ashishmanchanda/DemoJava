package striversheet.binarytree;

import java.util.ArrayList;
import java.util.List;

// TreeNode structure for the binary tree
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize the TreeNode with a value
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class InOrderTraversal {
    private void recursiveInorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        recursiveInorder(root.left, arr);
        arr.add(root.data);
        recursiveInorder(root.right, arr);
    }

    // Function to initiate inorder traversal and return the resulting list
    public List<Integer> inorder(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        recursiveInorder(root, arr);
        return arr;
    }
}

class InorderTraversal {
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InOrderTraversal sol = new InOrderTraversal();
        List<Integer> result = sol.inorder(root);

        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
