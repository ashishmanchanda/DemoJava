package DS.Tree;

// Java program to Get Level of a node in a Binary Tree
/* A tree node structure */
class NodeLevel
{
    int       data;
    NodeLevel left, right;

    public NodeLevel(int d)
    {
        data = d;
        left = right = null;
    }
}

class BinaryTree
{

    NodeLevel root;

    /* Helper function for getLevel(). It returns level of the data
    if data is present in tree, otherwise returns 0.*/
    int getLevelUtil(NodeLevel nodeLevel, int data, int level)
    {
        if (nodeLevel == null)
            return 0;

        if (nodeLevel.data == data)
            return level;

        int downlevel = getLevelUtil(nodeLevel.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevelUtil(nodeLevel.right, data, level + 1);
        return downlevel;
    }

    /* Returns level of given data value */
    int getLevel(NodeLevel nodeLevel, int data)
    {
        return getLevelUtil(nodeLevel, data, 1);
    }

    /* Driver function to test above functions */
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

		/* Constructing tree given in the above figure */
        tree.root = new NodeLevel(3);
        tree.root.left = new NodeLevel(2);
        tree.root.right = new NodeLevel(5);
        tree.root.left.left = new NodeLevel(1);
        tree.root.left.right = new NodeLevel(4);
        for (int x = 1; x <= 5; x++)
        {
           // int level = tree.getLevel(tree.root, x);
            //if (level != 0)
             //   System.out.println("Level of " + x + " is "
               //         + tree.getLevel(tree.root, x));
            //else
              //  System.out.println(x + " is not present in tree");
        }
    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)

