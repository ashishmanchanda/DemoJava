//package DS.Tree;

// Java program to print right view of binary tree

// A binary tree node
/*class NodeLevel {

    int data;
    NodeLevel left, right;

    NodeLevel(int item) {
        data = item;
        left = right = null;
    }
}

// class to access maximum level by reference
class Max_level {

    int max_level;
}

class BinaryTree {

    NodeLevel root;
    Max_level max = new Max_level();

    // Recursive function to print right view of a binary tree.
    void rightViewUtil(NodeLevel node, int level, Max_level max_level) {

        // Base Case
        if (node == null)
            return;

        // If this is the last NodeLevel of its level
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
    }

    void rightView()
    {
        rightView(root);
    }

    // A wrapper over rightViewUtil()
    void rightView(NodeLevel node) {

        rightViewUtil(node, 1, max);
    }

    // Driver program to test the above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new NodeLevel(1);
        tree.root.left = new NodeLevel(2);
        tree.root.right = new NodeLevel(3);
        tree.root.left.left = new NodeLevel(4);
        tree.root.left.right = new NodeLevel(5);
        tree.root.right.left = new NodeLevel(6);
        tree.root.right.right = new NodeLevel(7);
        tree.root.right.left.right = new NodeLevel(8);

        tree.rightView();

    }
}
*/

