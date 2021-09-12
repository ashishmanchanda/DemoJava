package DS.binarytree;

// Recursive Java program for level
// order traversal of Binary Tree

/* Class containing left and right child of current
node and key value*/
class LevelOrderTraversalNode
{
    int                     data;
    LevelOrderTraversalNode left, right;
    public LevelOrderTraversalNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class LevelOrderBinaryTree
{
    // Root of the Binary Tree
    LevelOrderTraversalNode root;

    public LevelOrderBinaryTree()
    {
        root = null;
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder1()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printCurrentLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(LevelOrderTraversalNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the current level */
    void printCurrentLevel (LevelOrderTraversalNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        LevelOrderBinaryTree tree = new LevelOrderBinaryTree();
        tree.root = new LevelOrderTraversalNode(1);
        tree.root.left = new LevelOrderTraversalNode(2);
        tree.root.right = new LevelOrderTraversalNode(3);
        tree.root.left.left = new LevelOrderTraversalNode(4);
        tree.root.left.right = new LevelOrderTraversalNode(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder1();
    }
}
