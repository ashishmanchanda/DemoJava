package DataStructuresPractice.binarytree;

// Java program to print boundary traversal of binary tree

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class BoundaryTraversalNode {
    int data;
    BoundaryTraversalNode left, right;

    BoundaryTraversalNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class BoundaryTraversal {
    BoundaryTraversalNode root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(BoundaryTraversalNode node)
    {
        if (node == null)
            return;

        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(BoundaryTraversalNode boundaryTraversalNode)
    {
        if (boundaryTraversalNode == null)
            return;

        if (boundaryTraversalNode.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(boundaryTraversalNode.data + " ");
            printBoundaryLeft(boundaryTraversalNode.left);
        }
        else if (boundaryTraversalNode.right != null) {
            System.out.print(boundaryTraversalNode.data + " ");
            printBoundaryLeft(boundaryTraversalNode.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(BoundaryTraversalNode boundaryTraversalNode)
    {
        if (boundaryTraversalNode == null)
            return;

        if (boundaryTraversalNode.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(boundaryTraversalNode.right);
            System.out.print(boundaryTraversalNode.data + " ");
        }
        else if (boundaryTraversalNode.left != null) {
            printBoundaryRight(boundaryTraversalNode.left);
            System.out.print(boundaryTraversalNode.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(BoundaryTraversalNode boundaryTraversalNode)
    {
        if (boundaryTraversalNode == null)
            return;

        System.out.print(boundaryTraversalNode.data + " ");

        // Print the left boundary in top-down manner.
        printBoundaryLeft(boundaryTraversalNode.left);

        // Print all leaf nodes
        printLeaves(boundaryTraversalNode.left);
        printLeaves(boundaryTraversalNode.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(boundaryTraversalNode.right);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = new BoundaryTraversalNode(20);
        tree.root.left = new BoundaryTraversalNode(8);
        tree.root.left.left = new BoundaryTraversalNode(4);
        tree.root.left.right = new BoundaryTraversalNode(12);
        tree.root.left.right.left = new BoundaryTraversalNode(10);
        tree.root.left.right.right = new BoundaryTraversalNode(14);
        tree.root.right = new BoundaryTraversalNode(22);
        tree.root.right.right = new BoundaryTraversalNode(25);
        tree.printBoundary(tree.root);
    }
}
