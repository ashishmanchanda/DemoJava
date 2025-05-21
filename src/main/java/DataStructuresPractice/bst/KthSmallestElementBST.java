package DataStructuresPractice.bst;

// Java program to find kth
// smallest value in BST

class KthSmallestBSTNode {
    int data;
    KthSmallestBSTNode left, right;

    KthSmallestBSTNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class KthSmallestBSTNodeGFG {

    // Recursive in-order function to
    // find kth smallest value in BST.
    // Returns -1 if value is not found.
    static int kthSmallestRecur(KthSmallestBSTNode root, int[] cnt, int k) {
        if (root == null) return -1;

        // Process left subtree.
        int left = kthSmallestRecur(root.left, cnt, k);

        // If kth smallest is found in left
        // subtree, then return it.
        if (left != -1) return left;

        // increment node count
        cnt[0]++;

        // If curr node is kth smallest,
        // return it.
        if (cnt[0] == k) return root.data;

        // Else process the right subtree
        // and return its value.
        int right = kthSmallestRecur(root.right, cnt, k);
        return right;
    }

    // Main function which initialises
    // count call for recursion.
    static int kthSmallest(KthSmallestBSTNode root, int k) {
        int[] cnt = {0};
        return kthSmallestRecur(root, cnt, k);
    }

    public static void main(String[] args) {

        // Binary search tree
        //      20
        //    /   \
        //   8     22
        //  / \
        // 4   12
        //    /  \
        //   10   14
        KthSmallestBSTNode root = new KthSmallestBSTNode(20);
        root.left = new KthSmallestBSTNode(8);
        root.right = new KthSmallestBSTNode(22);
        root.left.left = new KthSmallestBSTNode(4);
        root.left.right = new KthSmallestBSTNode(12);
        root.left.right.left = new KthSmallestBSTNode(10);
        root.left.right.right = new KthSmallestBSTNode(14);
        int k = 3;

        System.out.println(kthSmallest(root, k));
    }
}
