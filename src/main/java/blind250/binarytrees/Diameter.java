package blind250.binarytrees;

// Node Structure
class DiameterNode {
    int data;
    DiameterNode left, right;

    DiameterNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class Diameter {

    // Static variable to store maximum diameter
    static int maxDiameter = 0;

    // Recursive function to calculate height and update diameter
    static int diameterRecur(DiameterNode root) {
        if (root == null)
            return 0;

        // Find the height of left and right subtree
        int lHeight = diameterRecur(root.left);
        int rHeight = diameterRecur(root.right);

        // Update the global max diameter if this node gives a longer path
        if (lHeight + rHeight > maxDiameter)
            maxDiameter = lHeight + rHeight;

        // Return height of current subtree
        return 1 + Math.max(lHeight, rHeight);
    }

    // Function to get diameter of a binary tree
    static int diameter(DiameterNode root) {
        maxDiameter = 0;
        diameterRecur(root);
        return maxDiameter;
    }

    public static void main(String[] args) {

        DiameterNode root = new DiameterNode(1);
        root.right = new DiameterNode(2);
        root.right.left = new DiameterNode(3);
        root.right.right = new DiameterNode(4);
        root.right.left.left = new DiameterNode(5);
        root.right.right.right = new DiameterNode(6);

        System.out.println(diameter(root));
    }
}
