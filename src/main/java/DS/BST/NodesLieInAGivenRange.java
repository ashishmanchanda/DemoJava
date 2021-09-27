package DS.BST;

// Java code to count BST NodeLieInARanges that
// lie in a given range
class NodeLieInARangeBinarySearchTree {

    /* Class containing left and right child
    of current NodeLieInARange and key value*/
    static class NodeLieInARange {
        int data;
        NodeLieInARange left, right;

        public NodeLieInARange(int item) {
            data = item;
            left = right = null;
        }
    }

    // Root of BST
    NodeLieInARange root;

    // Constructor
    NodeLieInARangeBinarySearchTree() {
        root = null;
    }

    // Returns count of NodeLieInARanges in BST in
    // range [low, high]
    int getCount(NodeLieInARange NodeLieInARange, int low, int high)
    {
        // Base Case
        if(NodeLieInARange == null)
            return 0;

        // If current NodeLieInARange is in range, then
        // include it in count and recur for
        // left and right children of it
        if(NodeLieInARange.data >= low && NodeLieInARange.data <= high)
            return 1 + this.getCount(NodeLieInARange.left, low, high)+
                    this.getCount(NodeLieInARange.right, low, high);

            // If current NodeLieInARange is smaller than low,
            // then recur for right child
        else if(NodeLieInARange.data < low)
            return this.getCount(NodeLieInARange.right, low, high);

            // Else recur for left child
        else
            return this.getCount(NodeLieInARange.left, low, high);
    }

    // Driver function
    public static void main(String[] args) {
        NodeLieInARangeBinarySearchTree tree = new NodeLieInARangeBinarySearchTree();

        tree.root = new NodeLieInARange(10);
        tree.root.left	 = new NodeLieInARange(5);
        tree.root.right	 = new NodeLieInARange(50);
        tree.root.left.left = new NodeLieInARange(1);
        tree.root.right.left = new NodeLieInARange(40);
        tree.root.right.right = new NodeLieInARange(100);
		/* Let us constructed BST shown in above example
		10
		/ \
	5	 50
	/	 / \
	1	 40 100 */
        int l=5;
        int h=45;
        System.out.println("Count of NodeLieInARanges between [" + l + ", "
                + h+ "] is " + tree.getCount(tree.root,
                l, h));
    }
}
// This code is contributed by Kamal Rawal
