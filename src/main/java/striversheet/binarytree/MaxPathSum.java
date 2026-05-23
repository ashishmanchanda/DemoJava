package striversheet.binarytree;

// Tree Node Definition
class MaxPathSumINTreeNodes {
    int val;
    MaxPathSumINTreeNodes left, right;

    MaxPathSumINTreeNodes(int x) {
        val = x;
    }
}

class MaxPathSUmSolution {
    // Global variable to store max path sum
    int maxSum = Integer.MIN_VALUE;

    // Main function
    public int maxPathSum(MaxPathSumINTreeNodes root) {
        dfs(root);
        return maxSum;
    }

    // DFS recursive function
    private int dfs(MaxPathSumINTreeNodes node) {
        if (node == null) return 0;

        // Calculate left and right subtree max path
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Update max sum considering current node
        maxSum = Math.max(
                maxSum,
                left + right + node.val
        );

        // Return one-sided path
        return Math.max(left, right) + node.val;
    }
}

class MaxPathSumMain {
    public static void main(String[] args) {
        // Creating test tree
        MaxPathSumINTreeNodes root = new MaxPathSumINTreeNodes(-10);
        root.left = new MaxPathSumINTreeNodes(9);
        root.right = new MaxPathSumINTreeNodes(20);
        root.right.left = new MaxPathSumINTreeNodes(15);
        root.right.right = new MaxPathSumINTreeNodes(7);

        MaxPathSUmSolution sol = new MaxPathSUmSolution();
        System.out.println(
                "Maximum Path Sum: " +
                        sol.maxPathSum(root)
        );
    }
}

