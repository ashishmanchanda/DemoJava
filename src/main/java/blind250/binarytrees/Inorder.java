package blind250.binarytrees;
import java.util.ArrayList;

//Node Structure
class Node {
    int data;
    TreeNode left;
    TreeNode right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

 class Inorder {

    static void inOrder(TreeNode node, ArrayList<Integer> res) {
        if (node == null)
            return;

        // Traverse the left subtree first
        inOrder(node.left, res);

        // Visit the current node
        res.add(node.data);

        // Traverse the right subtree last
        inOrder(node.right, res);
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

        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);

        for(int node : res)
            System.out.print(node + " ");
    }
}