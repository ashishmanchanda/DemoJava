package neetcodequestions.trees;

// Java program to construct tree using
// inorder and preorder traversals
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    LongestPathNode left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class GfG {

    // Print tree as level order
    static void printLevelOrder(LongestPathNode root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<LongestPathNode> queue = new LinkedList<>();
        queue.add(root);
        int nonNull = 1;

        while (!queue.isEmpty() && nonNull > 0) {
            LongestPathNode curr = queue.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            nonNull--;

            System.out.print(curr.data + " ");
            queue.add(curr.left);
            queue.add(curr.right);
            if (curr.left != null)
                nonNull++;
            if (curr.right != null)
                nonNull++;
        }
    }

    // Function to find the index of an element in the array.
    static int search(int[] inorder, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }

    // Recursive function to build the binary tree.
    static LongestPathNode buildTreeRecur(int[] inorder, int[] preorder, int[] preIndex, int left, int right) {

        // For empty inorder array, return null
        if (left > right)
            return null;

        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;

        // create the root Node
        LongestPathNode root = new LongestPathNode(rootVal);

        // find the index of Root element in the in-order array.
        int index = search(inorder, rootVal, left, right);

        // Recursively create the left and right subtree.
        root.left = buildTreeRecur(inorder, preorder, preIndex, left, index - 1);
        root.right = buildTreeRecur(inorder, preorder, preIndex, index + 1, right);

        return root;
    }


    // Function to construct tree from its inorder and preorder traversals
    static LongestPathNode buildTree(int[] inorder, int[] preorder) {
        int[] preIndex = {0};
        return buildTreeRecur(inorder, preorder, preIndex, 0, preorder.length - 1);
    }

    public static void main(String[] args) {
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};

        LongestPathNode root = buildTree(inorder, preorder);
        printLevelOrder(root);
    }
}
