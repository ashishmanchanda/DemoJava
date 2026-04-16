package blind250.binarysearchtrees;

//Driver Code Starts
// Node Structure
class KthSmallestNode {
    int data;
    KthSmallestNode left, right;

    KthSmallestNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class KthSmallest {

    //Driver Code Ends
    // Recursive function for inorder traversal of the tree and
    // find its kth smallest value
    static int kthSmallestRecur(KthSmallestNode root, int[] cnt, int k) {
        if (root == null) return -1;

        int left = kthSmallestRecur(root.left, cnt, k);

        // If kth smallest is found in left
        // subtree, then return it
        if (left != -1) return left;

        cnt[0]++;

        // If curr node is kth smallest,
        // return it
        if (cnt[0] == k) return root.data;

        // Else process the right subtree
        // and return its value
        int right = kthSmallestRecur(root.right, cnt, k);
        return right;
    }

    // Function to find kth Smallest
    static int kthSmallest(KthSmallestNode root, int k) {
        int[] cnt = {0};
        return kthSmallestRecur(root, cnt, k);
    }
//Driver Code Starts

    public static void main(String[] args) {

        // Binary search tree
        //      20
        //    /   \
        //   8     22
        //  / \
        // 4   12
        //    /  \
        //   10   14
        KthSmallestNode root = new KthSmallestNode(20);
        root.left = new KthSmallestNode(8);
        root.right = new KthSmallestNode(22);
        root.left.left = new KthSmallestNode(4);
        root.left.right = new KthSmallestNode(12);
        root.left.right.left = new KthSmallestNode(10);
        root.left.right.right = new KthSmallestNode(14);
        int k = 3;

        System.out.println(kthSmallest(root, k));
    }
}

//Driver Code Ends