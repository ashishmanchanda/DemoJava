package DataStructuresPractice.binarytree;

// Java program to print left view of binary tree
// using Recursion
import java.util.ArrayList;

class LeftViewBinaryTree {
    int data;
    LeftViewBinaryTree left, right;

    LeftViewBinaryTree(int x) {
        data = x;
        left = right = null;
    }
}

// Helper function for the left view using Recursion
class LeftViewBinaryTreeImpl {
    static void RecLeftView(LeftViewBinaryTree root, int level,
                            int[] maxLevel, ArrayList<Integer> result) {
        if (root == null) return;

        // If current level is more than max level,
        // this is the first node of that level
        if (level > maxLevel[0]) {
            result.add(root.data);
            maxLevel[0] = level;
        }

        // Traverse left subtree first, then right subtree
        RecLeftView(root.left, level + 1, maxLevel, result);
        RecLeftView(root.right, level + 1, maxLevel, result);
    }

    // Function to return the left view of the binary tree
    static ArrayList<Integer> leftView(LeftViewBinaryTree root) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] maxLevel = new int[] {-1};

        // Start recursion with root at level 0
        RecLeftView(root, 0, maxLevel, result);

        return result;
    }

    static void printArray(ArrayList<Integer> arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        LeftViewBinaryTree root = new LeftViewBinaryTree(1);
        root.left = new LeftViewBinaryTree(2);
        root.right = new LeftViewBinaryTree(3);
        root.left.left = new LeftViewBinaryTree(4);
        root.left.right = new LeftViewBinaryTree(5);

        ArrayList<Integer> result = leftView(root);

        printArray(result);
    }
}
