package DS.Tree;


import java.util.HashMap;
/* A binary tree node structure */
class NodeNonAdjacent
{
    int             data;
    NodeNonAdjacent left, right;
    NodeNonAdjacent(int data)
    {
        this.data=data;
        left=right=null;
    }
};
 class FindSumOfNotAdjacentNodes {

    // method returns maximum sum possible from subtrees rooted
    // at grandChildrens of nodeNonAdjacent 'nodeNonAdjacent'
    public static int sumOfGrandChildren(NodeNonAdjacent nodeNonAdjacent, HashMap<NodeNonAdjacent,Integer> mp)
    {
        int sum = 0;
        // call for children of left child only if it is not NULL
        if (nodeNonAdjacent.left!=null)
            sum += getMaxSumUtil(nodeNonAdjacent.left.left, mp) +
                    getMaxSumUtil(nodeNonAdjacent.left.right, mp);

        // call for children of right child only if it is not NULL
        if (nodeNonAdjacent.right!=null)
            sum += getMaxSumUtil(nodeNonAdjacent.right.left, mp) +
                    getMaxSumUtil(nodeNonAdjacent.right.right, mp);
        return sum;
    }

    // Utility method to return maximum sum rooted at nodeNonAdjacent 'nodeNonAdjacent'
    public static int getMaxSumUtil(NodeNonAdjacent nodeNonAdjacent, HashMap<NodeNonAdjacent,Integer> mp)
    {
        if (nodeNonAdjacent == null)
            return 0;

        // If nodeNonAdjacent is already processed then return calculated
        // value from map
        if(mp.containsKey(nodeNonAdjacent))
            return mp.get(nodeNonAdjacent);

        // take current nodeNonAdjacent value and call for all grand children
        int incl = nodeNonAdjacent.data + sumOfGrandChildren(nodeNonAdjacent, mp);

        // don't take current nodeNonAdjacent value and call for all children
        int excl = getMaxSumUtil(nodeNonAdjacent.left, mp) +
                getMaxSumUtil(nodeNonAdjacent.right, mp);

        // choose maximum from both above calls and store that in map
        mp.put(nodeNonAdjacent,Math.max(incl, excl));

        return mp.get(nodeNonAdjacent);
    }

    // Returns maximum sum from subset of nodes
    // of binary tree under given constraints
    public static int getMaxSum(NodeNonAdjacent nodeNonAdjacent)
    {
        if (nodeNonAdjacent == null)
            return 0;
        HashMap<NodeNonAdjacent,Integer> mp=new HashMap<>();
        return getMaxSumUtil(nodeNonAdjacent, mp);
    }

    public static void main(String args[])
    {
        NodeNonAdjacent root = new NodeNonAdjacent(1);
        root.left = new NodeNonAdjacent(2);
        root.right = new NodeNonAdjacent(3);
        root.right.left = new NodeNonAdjacent(4);
        root.right.right = new NodeNonAdjacent(5);
        root.left.left = new NodeNonAdjacent(1);
        System.out.print(getMaxSum(root));
    }
}


//This code is contributed by Gaurav Tiwari

