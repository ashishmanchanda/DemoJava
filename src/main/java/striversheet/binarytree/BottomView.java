package striversheet.binarytree;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// Node Structure
class BottomViewNode {
    int data;
    BottomViewNode left, right;

    BottomViewNode(int x) {
        data = x;
        left = right = null;
    }
}

class BottomViewGFG {
    static int minHD, maxHD;

    // DFS function to fill hdMap with bottom-most nodes at each horizontal distance
    static void dfs(BottomViewNode root, int hd, int depth,
                    Map<Integer, Pair> hdMap) {
        if (root == null) return;

        minHD = Math.min(minHD, hd);
        maxHD = Math.max(maxHD, hd);

        // If this horizontal distance is
        // being visited for the first time or
        // we're at a deeper level, update it
        if (!hdMap.containsKey(hd)
                || depth >= hdMap.get(hd).depth) {
            hdMap.put(hd, new Pair(root.data, depth));
        }

        dfs(root.left, hd - 1, depth + 1, hdMap);
        dfs(root.right, hd + 1, depth + 1, hdMap);
    }

    // Returns the bottom view of a binary tree
    static ArrayList<Integer> bottomView(BottomViewNode root) {
        if (root == null) return new ArrayList<>();

        minHD = 0;
        maxHD = 0;

        // Map to store the last node's data and its depth
        // at each horizontal distance (HD)
        Map<Integer, Pair> hdMap = new HashMap<>();

        dfs(root, 0, 0, hdMap);

        ArrayList<Integer> result = new ArrayList<>();

        // Iterate through horizontal distances
        // in range from min HD to max HD
        for (int hd = minHD; hd <= maxHD; hd++ ) {
            result.add(hdMap.get(hd).data);
        }

        return result;
    }

    // Pair class to store
    // node data and its depth
    static class Pair {
        int data, depth;

        Pair(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {

        // Create binary tree
        //       20
        //      /  \
        //    8     22
        //   / \     \
        //  5   3     25
        //     / \    /
        //    10 14  28

        BottomViewNode root = new BottomViewNode(20);
        root.left = new BottomViewNode(8);
        root.right = new BottomViewNode(22);
        root.left.left = new BottomViewNode(5);
        root.left.right = new BottomViewNode(3);
        root.right.left = new BottomViewNode(4);
        root.left.right.left = new BottomViewNode(10);
        root.left.right.right = new BottomViewNode(14);
        root.right.right = new BottomViewNode(25);
        root.right.right.left = new BottomViewNode(28);

        minHD = 0; maxHD = 0;

        ArrayList<Integer> result = bottomView(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
