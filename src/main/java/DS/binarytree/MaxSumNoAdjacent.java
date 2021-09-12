package DS.binarytree;

// Java program to find maximum sum from a subset of
// MaxNaNodes of binary tree
import java.util.HashMap;
 class FindSumOfNotAdjacentMaxNaNodes {

    // method returns maximum sum possible from subtrees rooted
    // at grandChildrens of MaxNaNode 'MaxNaNode'
    public static int sumOfGrandChildren(MaxNaNode MaxNaNode, HashMap<MaxNaNode,Integer> mp)
    {
        int sum = 0;
        // call for children of left child only if it is not NULL
        if (MaxNaNode.left!=null)
            sum += getMaxSumUtil(MaxNaNode.left.left, mp) +
                    getMaxSumUtil(MaxNaNode.left.right, mp);

        // call for children of right child only if it is not NULL
        if (MaxNaNode.right!=null)
            sum += getMaxSumUtil(MaxNaNode.right.left, mp) +
                    getMaxSumUtil(MaxNaNode.right.right, mp);
        return sum;
    }

    // Utility method to return maximum sum rooted at MaxNaNode 'MaxNaNode'
    public static int getMaxSumUtil(MaxNaNode MaxNaNode, HashMap<MaxNaNode,Integer> mp)
    {
        if (MaxNaNode == null)
            return 0;

        // If MaxNaNode is already processed then return calculated
        // value from map
        if(mp.containsKey(MaxNaNode))
            return mp.get(MaxNaNode);

        // take current MaxNaNode value and call for all grand children
        int incl = MaxNaNode.data + sumOfGrandChildren(MaxNaNode, mp);

        // don't take current MaxNaNode value and call for all children
        int excl = getMaxSumUtil(MaxNaNode.left, mp) +
                getMaxSumUtil(MaxNaNode.right, mp);

        // choose maximum from both above calls and store that in map
        mp.put(MaxNaNode,Math.max(incl, excl));

        return mp.get(MaxNaNode);
    }

    // Returns maximum sum from subset of MaxNaNodes
    // of binary tree under given constraints
    public static int getMaxSum(MaxNaNode MaxNaNode)
    {
        if (MaxNaNode == null)
            return 0;
        HashMap<MaxNaNode,Integer> mp=new HashMap<>();
        return getMaxSumUtil(MaxNaNode, mp);
    }

    public static void main(String args[])
    {
        MaxNaNode root = new MaxNaNode(1);
        root.left = new MaxNaNode(2);
        root.right = new MaxNaNode(3);
        root.right.left = new MaxNaNode(4);
        root.right.right = new MaxNaNode(5);
        root.left.left = new MaxNaNode(1);
        System.out.print(getMaxSum(root));
    }
}

/* A binary tree MaxNaNode structure */
class MaxNaNode
{
    int data;
    MaxNaNode left, right;
    MaxNaNode(int data)
    {
        this.data=data;
        left=right=null;
    }
};
//This code is contributed by Gaurav Tiwari
