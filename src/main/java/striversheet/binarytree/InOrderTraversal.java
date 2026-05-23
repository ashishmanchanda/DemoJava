package striversheet.binarytree;

import java.util.ArrayList;
import java.util.List;

// TreeNode structure for the binary tree
class MaxPathSumTreeNodes {
    int data;
    MaxPathSumTreeNodes left;
    MaxPathSumTreeNodes right;

    // Constructor to initialize the TreeNode with a value
    MaxPathSumTreeNodes(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class InOrderTraversal {
    private void recursiveInorder(MaxPathSumTreeNodes root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        recursiveInorder(root.left, arr);
        arr.add(root.data);
        recursiveInorder(root.right, arr);
    }

    // Function to initiate inorder traversal and return the resulting list
    public List<Integer> inorder(MaxPathSumTreeNodes root) {
        List<Integer> arr = new ArrayList<>();
        recursiveInorder(root, arr);
        return arr;
    }
}

class InorderTraversal {
    public static void main(String[] args) {
        // Creating a sample binary tree
        MaxPathSumTreeNodes root = new MaxPathSumTreeNodes(1);
        root.left = new MaxPathSumTreeNodes(2);
        root.right = new MaxPathSumTreeNodes(3);
        root.left.left = new MaxPathSumTreeNodes(4);
        root.left.right = new MaxPathSumTreeNodes(5);

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
