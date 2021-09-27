package DS.BST;

// Recursive Java program to print lca of two LCANodes

// A binary tree LCANode
class LCANode
{
    int data;
    LCANode left, right;

    LCANode(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    LCANode root;

    /* Function to find LCA of n1 and n2. The function assumes that both
    n1 and n2 are present in BST */
    LCANode lca(LCANode LCANode, int n1, int n2)
    {
        if (LCANode == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (LCANode.data > n1 && LCANode.data > n2)
            return lca(LCANode.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (LCANode.data < n1 && LCANode.data < n2)
            return lca(LCANode.right, n1, n2);

        return LCANode;
    }

    /* Driver program to test lca() */
    public static void main(String args[])
    {
        // Let us construct the BST shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new LCANode(20);
        tree.root.left = new LCANode(8);
        tree.root.right = new LCANode(22);
        tree.root.left.left = new LCANode(4);
        tree.root.left.right = new LCANode(12);
        tree.root.left.right.left = new LCANode(10);
        tree.root.left.right.right = new LCANode(14);

        int n1 = 10, n2 = 14;
        LCANode t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }
}

// This code has been contributed by Mayank Jaiswal

