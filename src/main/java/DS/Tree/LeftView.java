package DS.Tree;

// Java program to print left view of binary tree

/* Class containing left and right child of current
node and key value*/
/*class NodeLevel {
    int data;
    NodeLevel left, right;

    public NodeLevel(int item)
    {
        data = item;
        left = right = null;
    }
}

/* Class to print the left view */
/*class BinaryTree {
    NodeLevel root;
    static int max_level = 0;

    // recursive function to print left view
    void leftViewUtil(NodeLevel node, int level)
    {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView()
    {
        leftViewUtil(root, 1);
    }

    /* testing for example nodes */
 /*   public static void main(String args[])
    {
		/* creating a binary tree and entering the nodes */
      /*(  BinaryTree tree = new BinaryTree();
        tree.root = new NodeLevel(12);
        tree.root.left = new NodeLevel(10);
        tree.root.right = new NodeLevel(30);
        tree.root.right.left = new NodeLevel(25);
        tree.root.right.right = new NodeLevel(40);

        tree.leftView();
    }
}*/
