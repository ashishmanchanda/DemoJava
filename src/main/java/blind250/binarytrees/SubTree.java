package blind250.binarytrees;

class SubTreeNode {
    int data;
    SubTreeNode left, right;

    SubTreeNode(int value) {
        data = value;
        left = right = null;
    }
}

class SubTree {

    // Serialize tree using preorder with null markers
    static void serialize(SubTreeNode root, StringBuilder s) {

        // Null node → add marker
        if (root == null) {
            s.append("# ");
            return;
        }

        // Add current node
        s.append(root.data).append(" ");

        // Recurse on left and right
        serialize(root.left, s);
        serialize(root.right, s);
    }

    static boolean isSubTree(SubTreeNode root1, SubTreeNode root2) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        // Serialize both trees
        serialize(root1, s1);
        serialize(root2, s2);

        // Check substring
        return s1.toString().contains(s2.toString());
    }

    public static void main(String[] args) {

        // Construct Tree root1
        //          26
        //         /  \
        //        10   3
        //       / \    \
        //      4   6    3
        //       \
        //        30
        SubTreeNode root1 = new SubTreeNode(26);
        root1.left = new SubTreeNode(10);
        root1.right = new SubTreeNode(3);
        root1.left.left = new SubTreeNode(4);
        root1.left.right = new SubTreeNode(6);
        root1.left.left.right = new SubTreeNode(30);
        root1.right.right = new SubTreeNode(3);

        // Construct Tree root2
        //          10
        //         /  \
        //        4    6
        //         \
        //          30
        SubTreeNode root2 = new SubTreeNode(10);
        root2.left = new SubTreeNode(4);
        root2.right = new SubTreeNode(6);
        root2.left.right = new SubTreeNode(30);

        if (isSubTree(root1, root2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}