package DataStructuresPractice.binarytree;

// Java code to implement the approach

import java.lang.*;

// Class to define the tree node
class IsBTHeightBalanced {
    int key;
    IsBTHeightBalanced left;
    IsBTHeightBalanced right;
    IsBTHeightBalanced(int k)
    {
        key = k;
        left = right = null;
    }
}

class IsBTHeightBalancedImpl {

    // Function to check if tree is height balanced
    public static int isBalanced(IsBTHeightBalanced root)
    {
        if (root == null)
            return 0;
        int lh = isBalanced(root.left);
        if (lh == -1)
            return -1;
        int rh = isBalanced(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }

    // Driver code
    public static void main(String args[])
    {
        IsBTHeightBalanced root = new IsBTHeightBalanced(10);
        root.left = new IsBTHeightBalanced(5);
        root.right = new IsBTHeightBalanced(30);
        root.right.left = new IsBTHeightBalanced(15);
        root.right.right = new IsBTHeightBalanced(20);

        if (isBalanced(root) > 0)
            System.out.print("Balanced");
        else
            System.out.print("Not Balanced");
    }
}