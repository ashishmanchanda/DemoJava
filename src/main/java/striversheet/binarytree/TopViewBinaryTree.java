package striversheet.binarytree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

// Node Structure
class TopViewBinaryTreeNode {
    int data;
    TopViewBinaryTreeNode left;
    TopViewBinaryTreeNode right;

    TopViewBinaryTreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class TopViewBinaryTreeGFG {

    // DFS Helper to store top view nodes
    static void dfs(TopViewBinaryTreeNode node, int hd, int level, Map<Integer, int[]> topNodes) {
        if (node == null) return;

        // If horizontal distance is encountered for
        // the first time or if it's at a higher level
        if (!topNodes.containsKey(hd) || topNodes.get(hd)[1] > level) {
            topNodes.put(hd, new int[]{node.data, level});
        }

        // Recur for left and right subtrees
        dfs(node.left, hd - 1, level + 1, topNodes);
        dfs(node.right, hd + 1, level + 1, topNodes);
    }

    // Finding the top view of a binary tree
    static ArrayList<Integer> topView(TopViewBinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Horizontal distance -> {node's value, level}
        TreeMap<Integer, int[]> topNodes = new TreeMap<>();

        // Start DFS traversal
        dfs(root, 0, 0, topNodes);

        // Collect nodes from the map
        for (Map.Entry<Integer, int[]> entry : topNodes.entrySet()) {
            result.add(entry.getValue()[0]);
        }

        return result;
    }

    public static void main(String[] args) {

        // Create a sample binary tree
        //     10
        //    /  \
        //   20   30
        //  / \   / \
        // 40  60 90  100

        TopViewBinaryTreeNode root = new TopViewBinaryTreeNode(10);
        root.left = new TopViewBinaryTreeNode(20);
        root.right = new TopViewBinaryTreeNode(30);
        root.left.left = new TopViewBinaryTreeNode(40);
        root.left.right = new TopViewBinaryTreeNode(60);
        root.right.left = new TopViewBinaryTreeNode(90);
        root.right.right = new TopViewBinaryTreeNode(100);

        ArrayList<Integer> result = topView(root);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
