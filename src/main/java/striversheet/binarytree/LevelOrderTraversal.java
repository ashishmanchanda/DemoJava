package striversheet.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node
class LevelOrderTreeNode {
    int data;
    LevelOrderTreeNode left;
    LevelOrderTreeNode right;
    LevelOrderTreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class LevelOrderTreeNodeSolution {
    // Function to perform level-order traversal of a binary tree
    public List<List<Integer>> levelOrder(LevelOrderTreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<LevelOrderTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                LevelOrderTreeNode node = q.poll();
                level.add(node.data);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}

// Separate main class
class LevelOrderTreeMain {
    public static void main(String[] args) {
        // Creating a sample binary tree
        LevelOrderTreeNode root = new LevelOrderTreeNode(1);
        root.left = new LevelOrderTreeNode(2);
        root.right = new LevelOrderTreeNode(3);
        root.left.left = new LevelOrderTreeNode(4);
        root.left.right = new LevelOrderTreeNode(5);

        LevelOrderTreeNodeSolution solution = new LevelOrderTreeNodeSolution();
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println("Level Order Traversal of Tree:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
