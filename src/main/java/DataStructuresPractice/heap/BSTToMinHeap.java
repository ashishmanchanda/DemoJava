package DataStructuresPractice.heap;

// Java implementation to convert the given
// BST to Min Heap
import java.util.ArrayList;

class BSTToMinHeapNode {
    int data;
    BSTToMinHeapNode left, right;

    BSTToMinHeapNode(int x) {
        data = x;
        left = right = null;
    }
}

class BSTIsHeapMain {

    // Function to perform inorder traversal of the BST
    // and store node values in an ArrayList
    static void inorderTraversal(BSTToMinHeapNode root,
                                 ArrayList<Integer> inorderArr) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree, store
        // the current node value,
        // and traverse the right subtree
        inorderTraversal(root.left, inorderArr);
        inorderArr.add(root.data);
        inorderTraversal(root.right, inorderArr);
    }

    // Function to perform preorder traversal of the tree
    // and copy the values from the inorder
    // ArrayList to the nodes
    static void preorderFill(BSTToMinHeapNode root,
                             ArrayList<Integer> inorderArr, int[] index) {
        if (root == null) {
            return;
        }

        // Copy the next element from the inorder array
        root.data = inorderArr.get(index[0]++);

        // Fill left and right subtree
        preorderFill(root.left, inorderArr, index);
        preorderFill(root.right, inorderArr, index);
    }

    // Function to convert BST to Min Heap
    static void convertBSTtoMinHeap(BSTToMinHeapNode root) {
        ArrayList<Integer> inorderArr
                = new ArrayList<>();

        // Step 1: Perform inorder traversal to
        // store values in sorted order
        inorderTraversal(root, inorderArr);

        // Using array to keep index as a reference
        int[] index = {0};

        // Step 2: Perform preorder traversal and
        // fill nodes with inorder values
        preorderFill(root, inorderArr, index);
    }

    static void preorderPrint(BSTToMinHeapNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public static void main(String[] args) {

        // Constructing the Binary Search Tree (BST)
        //          4
        //        /   \
        //       2     6
        //      / \   / \
        //     1   3 5   7
        BSTToMinHeapNode root = new BSTToMinHeapNode(4);
        root.left = new BSTToMinHeapNode(2);
        root.right = new BSTToMinHeapNode(6);
        root.left.left = new BSTToMinHeapNode(1);
        root.left.right = new BSTToMinHeapNode(3);
        root.right.left = new BSTToMinHeapNode(5);
        root.right.right = new BSTToMinHeapNode(7);

        convertBSTtoMinHeap(root);
        preorderPrint(root);
    }
}
