package DataStructuresPractice.bst;

// Java program to count BST nodes
// within a given range

class NodeLiesInGivenRange {
    int data;
    NodeLiesInGivenRange left, right;

    NodeLiesInGivenRange(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class NodeLiesInGivenRangeImpl {

    // Returns count of nodes in BST in range [l, h]
    static int getCount(NodeLiesInGivenRange root, int l, int h) {

        // Base case
        if (root == null) return 0;

        // If current node is in range,
        // include it and recur for left and right
        if (root.data <= h && root.data >= l)
            return 1 + getCount(root.left, l, h)
                    + getCount(root.right, l, h);

            // If current node is smaller
            // than low, recur for right child
        else if (root.data < l)
            return getCount(root.right, l, h);

            // Else recur for left child
        else
            return getCount(root.left, l, h);
    }

    public static void main(String[] args) {

        // Create a hard coded bst.
        //        10
        //       /  \
        //      5   50
        //     /   /  \
        //    1   40  100
        NodeLiesInGivenRange root = new NodeLiesInGivenRange(10);
        root.left = new NodeLiesInGivenRange(5);
        root.right = new NodeLiesInGivenRange(50);
        root.left.left = new NodeLiesInGivenRange(1);
        root.right.left = new NodeLiesInGivenRange(40);
        root.right.right = new NodeLiesInGivenRange(100);

        int l = 5;
        int h = 45;

        System.out.println(getCount(root, l, h));
    }
}
