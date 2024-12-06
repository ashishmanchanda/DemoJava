package DataStructuresPractice.binarytree;

// Recursive Java program for level
// order traversal of Binary Tree

class Node {
    int data;
    LevelOrderTraversalQueue left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class LevelOrderTraversal {

    // Function to print level order
    // traversal of tree
    static void printLevelOrder(LevelOrderTraversalQueue root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

    // Compute the "height" of a tree
    static int height(LevelOrderTraversalQueue root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    // Print nodes at the current level
    static void printCurrentLevel(LevelOrderTraversalQueue root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public static void main(String args[]) {
        LevelOrderTraversalQueue root = new LevelOrderTraversalQueue(1);
        root.left = new LevelOrderTraversalQueue(2);
        root.right = new LevelOrderTraversalQueue(3);
        root.left.left = new LevelOrderTraversalQueue(4);
        root.left.right = new LevelOrderTraversalQueue(5);
        printLevelOrder(root);
    }
}