package striversheet.binarytree;


// TreeNode structure
class ChildrenSumTreeNode {
    int val;
    ChildrenSumTreeNode left;
    ChildrenSumTreeNode right;

    public ChildrenSumTreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

 class ChildrenSumSolution {
    // Function to change the values of the nodes
    // based on the sum of its children's values.
    public void changeTree(ChildrenSumTreeNode root) {
        // Base case: If the current node
        // is null, return and do nothing.
        if (root == null) {
            return;
        }

        // Calculate the sum of the values of
        // the left and right children, if they exist.
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        // Compare the sum of children with
        // the current node's value and update
        if (child >= root.val) {
            root.val = child;
        } else {
            // If the sum is smaller, update the
            // child with the current node's value.
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Recursively call the function
        // on the left and right children.
        changeTree(root.left);
        changeTree(root.right);

        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        int tot = 0;
        if (root.left != null) {
            tot += root.left.val;
        }
        if (root.right != null) {
            tot += root.right.val;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }
}

// Function to print the inorder
// traversal of the tree
class TreeTraversal {
    public static void inorderTraversal(ChildrenSumTreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}

class CHMain {
    public static void main(String[] args) {
        // Create the binary tree
        ChildrenSumTreeNode root = new ChildrenSumTreeNode(3);
        root.left = new ChildrenSumTreeNode(5);
        root.right = new ChildrenSumTreeNode(1);
        root.left.left = new ChildrenSumTreeNode(6);
        root.left.right = new ChildrenSumTreeNode(2);
        root.right.left = new ChildrenSumTreeNode(0);
        root.right.right = new ChildrenSumTreeNode(8);
        root.left.right.left = new ChildrenSumTreeNode(7);
        root.left.right.right = new ChildrenSumTreeNode(4);

        ChildrenSumSolution sol = new ChildrenSumSolution();

        // Print the inorder traversal
        // of tree before modification
        System.out.print("Binary Tree before modification: ");
        TreeTraversal.inorderTraversal(root);
        System.out.println();

        // Call the changeTree function
        // to modify the binary tree
        sol.changeTree(root);

        // Print the inorder traversal
        // after modification
        System.out.print("Binary Tree after Children Sum Property: ");
        TreeTraversal.inorderTraversal(root);
        System.out.println();
    }
}

