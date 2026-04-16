package blind250.binarytrees;

import java.util.ArrayList;
import java.util.List;

// Node Structure
class LCANode {
    int data;
    LCANode left, right;

    LCANode(int value) {
        data = value;
        left = right = null;
    }
}

class LCA {

    static LCANode lca(LCANode root, LCANode n1, LCANode n2) {

        List<LCANode> path1 = new ArrayList<>();
        List<LCANode> path2 = new ArrayList<>();

        // Find paths from root to n1
        // and root to n2.
        if(!findPath(root, path1, n1) ||
                !findPath(root, path2, n2))
            return null;

        // Compare the paths to get the first
        // different value
        int i = 0;
        for(i = 0; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i))
                return path1.get(i-1);
        }

        return path1.get(i-1);
    }

    // Finds the path from root to given node
    static boolean findPath(LCANode root, List<LCANode> path, LCANode n) {

        if (root == null) {
            return false;
        }

        // Store current node
        path.add(root);

        if (root == n ||
                findPath(root.left, path, n) ||
                findPath(root.right, path, n)) {
            return true;
        }

        // remove root from path and return false
        path.remove(path.size() - 1);

        return false;
    }

    public static void main(String[] args) {

        // Create binary tree:
        //			   1
        //           /   \
        //          2     3
        //               / \
        //              6   7
        //             /
        //            8

        LCANode root = new LCANode(1);
        root = new LCANode(1);
        root.left = new LCANode(2);
        root.right = new LCANode(3);
        root.right.left = new LCANode(6);
        root.right.right = new LCANode(7);
        root.right.left.left = new LCANode(8);

        LCANode n1 = root.right.right;
        LCANode n2 = root.right.left.left;

        LCANode ans = lca(root, n1, n2);

        System.out.println(ans.data);
    }
}
