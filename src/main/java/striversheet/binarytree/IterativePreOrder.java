package striversheet.binarytree;

class IterativePreOrderNode {
    int val;
    IterativePreOrderNode left;
    IterativePreOrderNode right;

    // Constructor to initialize a new tree node with a given value
    public IterativePreOrderNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class IterativePreOrder {

    // Function to perform preorder traversal of a binary tree iteratively
    public static java.util.List<Integer> preorderTraversal(IterativePreOrderNode root) {
        java.util.List<Integer> preorder = new java.util.ArrayList<>();  // List to store the preorder traversal result

        // If the root is null, return an empty traversal result
        if (root == null) {
            return preorder;
        }

        java.util.Stack<IterativePreOrderNode> st = new java.util.Stack<>();  // Stack to store nodes during traversal
        st.push(root);  // Push the root node onto the stack

        // Perform iterative preorder traversal
        while (!st.isEmpty()) {
            root = st.pop();  // Get the current node from the top of the stack
            preorder.add(root.val);  // Add the node's value to the preorder result

            // Push the right child onto the stack if exists
            if (root.right != null) {
                st.push(root.right);
            }

            // Push the left child onto the stack if exists
            if (root.left != null) {
                st.push(root.left);
            }
        }

        // Return the preorder traversal result
        return preorder;
    }
}

class IterativePreOrderMain {

    public static void main(String[] args) {
        // Creating a binary tree
        IterativePreOrderNode root = new IterativePreOrderNode(1);
        root.left = new IterativePreOrderNode(2);
        root.right = new IterativePreOrderNode(3);
        root.left.left = new IterativePreOrderNode(4);
        root.left.right = new IterativePreOrderNode(5);

        // Getting the preorder traversal
        java.util.List<Integer> result = IterativePreOrder.preorderTraversal(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}