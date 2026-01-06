package DataStructuresPractice.binarytree;

// Java program to print right view of binary tree
// using Recursion
import java.util.ArrayList;

class RightViewBinaryTree {
    int data;
    RightViewBinaryTree left, right;

    RightViewBinaryTree(int x) {
        data = x;
        left = right = null;
    }
}

// Helper function for the right view using Recursion
class RightViewBinaryTreeImpl {
    static void RecursiveRightView(RightViewBinaryTree root, int level,
                                   int[] maxLevel, ArrayList<Integer> result) {
        if (root == null) return;

        // If current level is more than max level,
        // this is the first node of that level
        if (level > maxLevel[0]) {
            result.add(root.data);
            maxLevel[0] = level;
        }

        // Traverse right subtree first, then left subtree
        RecursiveRightView(root.right, level + 1,
                maxLevel, result);
        RecursiveRightView(root.left, level + 1,
                maxLevel, result);
    }

    // Function to return the right view of the binary tree
    static ArrayList<Integer> rightView(RightViewBinaryTree root) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] maxLevel = new int[] {-1};

        // Start recursion with root at level 0
        RecursiveRightView(root, 0, maxLevel, result);

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
        //           / \
        //          4   5
        RightViewBinaryTree root = new RightViewBinaryTree(1);
        root.left = new RightViewBinaryTree(2);
        root.right = new RightViewBinaryTree(3);
        root.right.left = new RightViewBinaryTree(4);
        root.right.right = new RightViewBinaryTree(5);

        ArrayList<Integer> result = rightView(root);

        printArray(result);
    }
}
