package DS.binarytree;

/* Java program to determine if binary tree is
HBHeight balanced or not */

/* A binary tree HBNode has data, pointer to left child,
and a pointer to right child */
class HBNode {

    int data;
    HBNode left, right;

    HBNode(int d)
    {
        data = d;
        left = right = null;
    }
}

// A wrapper class used to modify HBHeight across
// recursive calls.
class HBHeight {
    int HBHeight = 0;
}

class HBBinaryTree {

    HBNode root;

    /* Returns true if binary tree with root as root is HBHeight-balanced */
    boolean isBalanced(HBNode root, HBHeight HBHeight)
    {
        /* If tree is empty then return true */
        if (root == null) {
            HBHeight.HBHeight = 0;
            return true;
        }

        /* Get HBHeights of left and right sub trees */
        HBHeight lHBHeight = new HBHeight(), rHBHeight = new HBHeight();
        boolean l = isBalanced(root.left, lHBHeight);
        boolean r = isBalanced(root.right, rHBHeight);
        int lh = lHBHeight.HBHeight, rh = rHBHeight.HBHeight;

		/* HBHeight of current HBNode is max of HBHeights of
		left and right subtrees plus 1*/
        HBHeight.HBHeight = (lh > rh ? lh : rh) + 1;

		/* If difference between HBHeights of left and right
		subtrees is more than 2 then this HBNode is not balanced
		so return 0 */
        if (Math.abs(lh - rh) >= 2)
            return false;

		/* If this HBNode is balanced and left and right subtrees
		are balanced then return true */
        else
            return l && r;
    }

    public static void main(String args[])
    {
        HBHeight HBHeight = new HBHeight();

		/* Constructed binary tree is
				1
				/ \
				2	 3
			/ \ /
			4	 5 6
			/
		7		 */
        HBBinaryTree tree = new HBBinaryTree();
        tree.root = new HBNode(1);
        tree.root.left = new HBNode(2);
        tree.root.right = new HBNode(3);
        tree.root.left.left = new HBNode(4);
        tree.root.left.right = new HBNode(5);
        tree.root.right.right = new HBNode(6);
        tree.root.left.left.left = new HBNode(7);

        if (tree.isBalanced(tree.root, HBHeight))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)
