package DataStructuresPractice.binarytree;

// Java implementation to find the sum of nodes
// on the longest path from root to leaf node
class RootToLeafPathMaxSum {
    int data;
    RootToLeafPathMaxSum left, right;

    RootToLeafPathMaxSum(int x) {
        data = x;
        left = right = null;
    }
}
class RootToLeafpath {
    static void sumOfRootToLeaf(RootToLeafPathMaxSum root, int sum,
                                int length, int[] maxLen,
                                int[] maxSum) {

        // Base case: if the current node is null
        if (root == null) {

            // Checking if the current path has a longer
            // length and update maxLen and maxSum
            // accordingly
            if (length > maxLen[0]) {
                maxLen[0] = length;
                maxSum[0] = sum;
            }

            // If the lengths are equal, check if the
            // current sum is greater and update maxSum if
            // necessary
            else if (length == maxLen[0]
                    && sum > maxSum[0]) {
                maxSum[0] = sum;
            }
            return;
        }

        // Recursively calculating the sum of
        // the left and right subtrees
        sumOfRootToLeaf(root.left, sum + root.data,
                length + 1, maxLen, maxSum);
        sumOfRootToLeaf(root.right, sum + root.data,
                length + 1, maxLen, maxSum);
    }

    // Function to calculate the sum of the longest root to
    // leaf path
    static int sumOfLongRootToLeafPath(RootToLeafPathMaxSum root) {

        // Base case: if the tree is empty
        if (root == null)
            return 0;

        // Initializing the variables to
        // store the maximum length and sum
        int[] maxSum = { Integer.MIN_VALUE };
        int[] maxLen = { 0 };

        // Calling the utility function
        sumOfRootToLeaf(root, 0, 0, maxLen, maxSum);

        // Returning the maximum sum
        return maxSum[0];
    }

    public static void main(String[] args) {

        // binary tree formation
        //        4
        //       / \
        //      2   5
        //     / \ / \
        //    7  1 2  3
        //      /
        //     6
        RootToLeafPathMaxSum root = new RootToLeafPathMaxSum(4);
        root.left = new RootToLeafPathMaxSum(2);
        root.right = new RootToLeafPathMaxSum(5);
        root.left.left = new RootToLeafPathMaxSum(7);
        root.left.right = new RootToLeafPathMaxSum(1);
        root.right.left = new RootToLeafPathMaxSum(2);
        root.right.right = new RootToLeafPathMaxSum(3);
        root.left.right.left = new RootToLeafPathMaxSum(6);

        System.out.println(sumOfLongRootToLeafPath(root));
    }
}
