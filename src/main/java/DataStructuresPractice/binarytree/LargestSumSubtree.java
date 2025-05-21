package DataStructuresPractice.binarytree;

// Java program to find largest subtree
// sum in a given binary tree.
class LargestSumSubtree {
    int data;
    LargestSumSubtree left, right;

    LargestSumSubtree(int x) {
        data = x;
        left = right = null;
    }
}

// Helper function to find largest
// subtree sum recursively.
class LargestSumSubtreeImpl {

    static int findLargestSubtreeSumUtil
            (LargestSumSubtree root, int[] ans) {

        // If current node is null then
        // return 0 to parent node.
        if (root == null)
            return 0;

        // Subtree sum rooted at current node.
        int currSum = root.data +
                findLargestSubtreeSumUtil(root.left, ans)
                + findLargestSubtreeSumUtil(root.right, ans);

        // Update answer if current subtree
        // sum is greater than answer so far.
        ans[0] = Math.max(ans[0], currSum);

        // Return current subtree sum to
        // its parent node.
        return currSum;
    }

    // Function to find largest subtree sum.
    static int findLargestSubtreeSum(LargestSumSubtree root) {

        // If tree does not exist,
        // then answer is 0.
        if (root == null)
            return 0;

        // Variable to store maximum subtree sum.
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;

        // Call to recursive function to
        // find maximum subtree sum.
        findLargestSubtreeSumUtil(root, ans);

        return ans[0];
    }

    public static void main(String[] args) {

        // Representation of the given tree
        //          1
        //        /   \
        //      -2     3
        //      / \   / \
        //     4   5 -6  2
        LargestSumSubtree root = new LargestSumSubtree(1);
        root.left = new LargestSumSubtree(-2);
        root.right = new LargestSumSubtree(3);
        root.left.left = new LargestSumSubtree(4);
        root.left.right = new LargestSumSubtree(5);
        root.right.left = new LargestSumSubtree(-6);
        root.right.right = new LargestSumSubtree(2);

        System.out.println(findLargestSubtreeSum(root));
    }
}
