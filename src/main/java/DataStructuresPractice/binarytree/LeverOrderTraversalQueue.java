package DataStructuresPractice.binarytree;

// Iterative Queue based Java program
// to do level order traversal
// of Binary Tree
import java.util.LinkedList;
import java.util.Queue;

class LevelOrderTraversalQueue {
    int data;
    LevelOrderTraversalQueue left, right;
    public LevelOrderTraversalQueue(int item) {
        data = item;
        left = null;
        right = null;
    }
}

class GfG {

    // Given a binary tree. Print
    // its nodes in level order
    // using array for implementing queue
    static void printLevelOrder(LevelOrderTraversalQueue root) {
        Queue<LevelOrderTraversalQueue> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            LevelOrderTraversalQueue curr = queue.poll();
            System.out.print(curr.data + " ");

            // Enqueue left child
            if (curr.left != null) {
                queue.add(curr.left);
            }

            // Enqueue right child
            if (curr.right != null) {
                queue.add(curr.right);
            }
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
