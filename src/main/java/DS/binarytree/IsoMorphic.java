package DS.IsoMorphicBinaryTree;

// An iterative java program to solve tree isomorphism problem

/* A binary tree IsoMorphicNode has data, pointer to left and right children */
class IsoMorphicNode
{
    int data;
    IsoMorphicNode left, right;

    IsoMorphicNode(int item)
    {
        data = item;
        left = right;
    }
}

class IsoMorphicBinaryTree
{
    IsoMorphicNode root1, root2;

    /* Given a binary tree, print its IsoMorphicNodes in reverse level order */
    boolean isIsomorphic(IsoMorphicNode n1, IsoMorphicNode n2)
    {
        // Both roots are NULL, trees isomorphic by definition
        if (n1 == null && n2 == null)
            return true;

        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (n1 == null || n2 == null)
            return false;

        if (n1.data != n2.data)
            return false;

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these IsoMorphicNodes have NOT been
        // "Flipped".
        // Both of these subtrees have to be isomorphic.
        // Case 2: The subtrees rooted at these IsoMorphicNodes have been "Flipped"
        return (isIsomorphic(n1.left, n2.left) &&
                isIsomorphic(n1.right, n2.right))
                || (isIsomorphic(n1.left, n2.right) &&
                isIsomorphic(n1.right, n2.left));
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        IsoMorphicBinaryTree tree = new IsoMorphicBinaryTree();

        // Let us create trees shown in above diagram
        tree.root1 = new IsoMorphicNode(1);
        tree.root1.left = new IsoMorphicNode(2);
        tree.root1.right = new IsoMorphicNode(3);
        tree.root1.left.left = new IsoMorphicNode(4);
        tree.root1.left.right = new IsoMorphicNode(5);
        tree.root1.right.left = new IsoMorphicNode(6);
        tree.root1.left.right.left = new IsoMorphicNode(7);
        tree.root1.left.right.right = new IsoMorphicNode(8);

        tree.root2 = new IsoMorphicNode(1);
        tree.root2.left = new IsoMorphicNode(3);
        tree.root2.right = new IsoMorphicNode(2);
        tree.root2.right.left = new IsoMorphicNode(4);
        tree.root2.right.right = new IsoMorphicNode(5);
        tree.root2.left.right = new IsoMorphicNode(6);
        tree.root2.right.right.left = new IsoMorphicNode(8);
        tree.root2.right.right.right = new IsoMorphicNode(7);

        if (tree.isIsomorphic(tree.root1, tree.root2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

// This code has been contributed by Mayank Jaiswal
