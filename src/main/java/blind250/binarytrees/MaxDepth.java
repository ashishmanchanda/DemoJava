package blind250.binarytrees;

// Node structure
class DepthNode {
    int data;
    DepthNode left, right;

    DepthNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class GfG {
    static int height(DepthNode root) {
        if (root == null)
            return -1;

        // compute the height of left and right subtrees
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //     12
        //    /  \
        //   8   18
        //  / \
        // 5   11
        DepthNode root = new DepthNode(12);
        root.left = new DepthNode(8);
        root.right = new DepthNode(18);
        root.left.left = new DepthNode(5);
        root.left.right = new DepthNode(11);

        System.out.println(height(root));
    }
}