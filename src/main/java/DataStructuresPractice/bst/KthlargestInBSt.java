package DataStructuresPractice.bst;

//Java Program to find kth largest element

class KthLargestNode {
    int data;
    KthLargestNode left, right;

    KthLargestNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class KthLargestGfG {

    // Function which will traverse the BST in
    // reverse inorder manner.
    static int kthLargestRecur(KthLargestNode root, int[] cnt, int k) {

        // Base case
        if (root == null)
            return -1;

        // Traverse the right subtree first
        // (larger elements)
        int right = kthLargestRecur(root.right, cnt, k);

        // If kth largest number is present in right
        // subtree, return it.
        if (right != -1)
            return right;

        // Increment the node count.
        cnt[0]++;

        // If root node is the kth largest element,
        // return it.
        if (cnt[0] == k)
            return root.data;

        // Otherwise, traverse the left subtree.
        return kthLargestRecur(root.left, cnt, k);
    }

    static int kthLargest(KthLargestNode root, int k) {
        int[] cnt = new int[1];
        return kthLargestRecur(root, cnt, k);
    }

    public static void main(String[] args) {

        // Create a hard coded tree.
        //         20
        //       /   \
        //      8     22
        //    /  \
        //   4   12
        //      /  \
        //     10   14
        KthLargestNode root = new KthLargestNode(20);
        root.left = new KthLargestNode(8);
        root.right = new KthLargestNode(22);
        root.left.left = new KthLargestNode(4);
        root.left.right = new KthLargestNode(12);
        root.left.right.left = new KthLargestNode(10);
        root.left.right.right = new KthLargestNode(14);

        int k = 3;
        System.out.println(kthLargest(root, k));
    }
}