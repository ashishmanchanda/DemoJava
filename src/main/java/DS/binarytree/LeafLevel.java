package DS.binarytree;

// Java program to check if all leaves are at same level

// A binary tree LeafLevelNode
class LeafLevelNode
{
    int data;
    LeafLevelNode left, right;

    LeafLevelNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class Leaf
{
    int leaflevel=0;
}

class LeafLevelBinaryTree
{
    LeafLevelNode root;
    Leaf mylevel = new Leaf();

    /* Recursive function which checks whether all leaves are at same
    level */
    boolean checkUtil(LeafLevelNode LeafLevelNode, int level, Leaf leafLevel)
    {
        // Base case
        if (LeafLevelNode == null)
            return true;

        // If a leaf LeafLevelNode is encountered
        if (LeafLevelNode.left == null && LeafLevelNode.right == null)
        {
            // When a leaf LeafLevelNode is found first time
            if (leafLevel.leaflevel == 0)
            {
                // Set first found leaf's level
                leafLevel.leaflevel = level;
                return true;
            }

            // If this is not first leaf LeafLevelNode, compare its level with
            // first leaf's level
            return (level == leafLevel.leaflevel);
        }

        // If this LeafLevelNode is not leaf, recursively check left and right
        // subtrees
        return checkUtil(LeafLevelNode.left, level + 1, leafLevel)
                && checkUtil(LeafLevelNode.right, level + 1, leafLevel);
    }

    /* The main function to check if all leafs are at same level.
    It mainly uses checkUtil() */
    boolean check(LeafLevelNode LeafLevelNode)
    {
        int level = 0;
        return checkUtil(LeafLevelNode, level, mylevel);
    }

    public static void main(String args[])
    {
        // Let us create the tree as shown in the example
        LeafLevelBinaryTree tree = new LeafLevelBinaryTree();
        tree.root = new LeafLevelNode(12);
        tree.root.left = new LeafLevelNode(5);
        tree.root.left.left = new LeafLevelNode(3);
        tree.root.left.right = new LeafLevelNode(9);
        tree.root.left.left.left = new LeafLevelNode(1);
        tree.root.left.right.left = new LeafLevelNode(1);
        if (tree.check(tree.root))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }
}

// This code has been contributed by Mayank Jaiswal
