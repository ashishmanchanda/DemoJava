package DataStructuresPractice.binarytree;

// Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree

/* Class containing left and right child of current
 node and key value*/
class LCABinaryTree {
    int data;
    LCABinaryTree left, right;

    public LCABinaryTree(int item)
    {
        data = item;
        left = right = null;
    }
}

 class BinaryTree1 {
    // Root of the Binary Tree
    LCABinaryTree root;

    LCABinaryTree findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    LCABinaryTree findLCA(LCABinaryTree node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key,
        // report the presence by returning root (Note that
        // if a key is ancestor of other, then the ancestor
        // key becomes LCA
        if (node.data == n1 || node.data == n2)
            return node;

        // Look for keys in left and right subtrees
        LCABinaryTree left_lca = findLCA(node.left, n1, n2);
        LCABinaryTree right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then
        // one key is present in once subtree and other is
        // present in other, So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree
        // is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTree1 tree = new BinaryTree1();
        tree.root = new LCABinaryTree(1);
        tree.root.left = new LCABinaryTree(2);
        tree.root.right = new LCABinaryTree(3);
        tree.root.left.left = new LCABinaryTree(4);
        tree.root.left.right = new LCABinaryTree(5);
        tree.root.right.left = new LCABinaryTree(6);
        tree.root.right.right = new LCABinaryTree(7);
        System.out.println("LCA(4, 5) = "
                + tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = "
                + tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = "
                + tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = "
                + tree.findLCA(2, 4).data);
    }
}
