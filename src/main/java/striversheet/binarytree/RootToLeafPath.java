package striversheet.binarytree;

import java.util.*;

// TreeNode class for Binary Tree
class RootToLeafPathNode {
    int val;
    RootToLeafPathNode left, right;

    // Constructor to initialize the node
    RootToLeafPathNode(int x) {
        val = x;
        left = right = null;
    }
}

class RootToLeafPathNodeSolution {
    // Function to get path from root to node with value x
    public boolean getPath(RootToLeafPathNode root, List<Integer> arr, int x) {
        // Base case: If node is null
        if (root == null)
            return false;

        // Add current node to path
        arr.add(root.val);

        // If current node is the target
        if (root.val == x)
            return true;

        // Recurse into left and right children
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;

        // Backtrack if not found
        arr.remove(arr.size() - 1);
        return false;
    }

    // Function to return the final path vector
    public List<Integer> solve(RootToLeafPathNode root, int x) {
        // Initialize result list
        List<Integer> arr = new ArrayList<>();

        // If tree is empty
        if (root == null)
            return arr;

        // Call helper function
        getPath(root, arr, x);
        return arr;
    }
}

 class RootToLeafPathNodeMain {
    public static void main(String[] args) {
        // Construct the tree
        RootToLeafPathNode root = new RootToLeafPathNode(3);
        root.left = new RootToLeafPathNode(5);
        root.right = new RootToLeafPathNode(1);
        root.left.left = new RootToLeafPathNode(6);
        root.left.right = new RootToLeafPathNode(2);
        root.right.left = new RootToLeafPathNode(0);
        root.right.right = new RootToLeafPathNode(8);
        root.left.right.left = new RootToLeafPathNode(7);
        root.left.right.right = new RootToLeafPathNode(4);

        // Create solution object
        RootToLeafPathNodeSolution sol = new RootToLeafPathNodeSolution();

        // Target node value
        int target = 7;

        // Get path from root to target
        List<Integer> path = sol.solve(root, target);

        // Print the path
        System.out.print("Path from root to node " + target + ": ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1)
                System.out.print(" -> ");
        }
    }
}
