package DS.binarytree;

// Java program to implement iterative preorder traversal
import java.util.Stack;

// A binary tree ItPreNode
class ItPreNode {

    int data;
    ItPreNode left, right;

    ItPreNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class ItBinaryTree {

    ItPreNode root;

    void iterativePreorder()
    {
        iterativePreorder(root);
    }

    // An iterative process to print preorder traversal of Binary tree
    void iterativePreorder(ItPreNode ItPreNode)
    {

        // Base Case
        if (ItPreNode == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<ItPreNode> ItPreNodeStack = new Stack<ItPreNode>();
        ItPreNodeStack.push(root);

		/* Pop all items one by one. Do following for every popped item
		a) print it
		b) push its right child
		c) push its left child
		Note that right child is pushed first so that left is processed first */
        while (ItPreNodeStack.empty() == false) {

            // Pop the top item from stack and print it
            ItPreNode myItPreNode = ItPreNodeStack.peek();
            System.out.print(myItPreNode.data + " ");
            ItPreNodeStack.pop();

            // Push right and left children of the popped ItPreNode to stack
            if (myItPreNode.right != null) {
                ItPreNodeStack.push(myItPreNode.right);
            }
            if (myItPreNode.left != null) {
                ItPreNodeStack.push(myItPreNode.left);
            }
        }
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        ItBinaryTree tree = new ItBinaryTree();
        tree.root = new ItPreNode(10);
        tree.root.left = new ItPreNode(8);
        tree.root.right = new ItPreNode(2);
        tree.root.left.left = new ItPreNode(3);
        tree.root.left.right = new ItPreNode(5);
        tree.root.right.left = new ItPreNode(2);
        tree.iterativePreorder();
    }
}

// This code has been contributed by Mayank Jaiswal

