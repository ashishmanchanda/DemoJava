package blind250.binarytrees;

import java.util.ArrayList;

// Node Structure
class SDBinaryTreeNode {
    int data;
    SDBinaryTreeNode left, right;
    SDBinaryTreeNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class SDBinaryTree {

    // Function to store the preorder
    static void serializePreOrder(SDBinaryTreeNode root, ArrayList<Integer> arr) {

        // Push -1 if root is null.
        if (root == null) {
            arr.add(-1);
            return;
        }

        // Push the root into result.
        arr.add(root.data);
        serializePreOrder(root.left, arr);
        serializePreOrder(root.right, arr);
    }

    //  function to serialize a tree.
    static ArrayList<Integer> serialize(SDBinaryTreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        serializePreOrder(root, arr);
        return arr;
    }

    // Function to restore the tree from preorder
    static SDBinaryTreeNode deserializePreOrder(int[] i, ArrayList<Integer> arr) {

        // if elemnt is -1 return null
        if (arr.get(i[0]) == -1) {
            i[0]++;
            return null;
        }

        // Create the root node.
        SDBinaryTreeNode root = new SDBinaryTreeNode(arr.get(i[0]));
        i[0]++;

        // Create the left and right subtree.
        root.left = deserializePreOrder(i, arr);
        root.right = deserializePreOrder(i, arr);

        return root;
    }

    // function to deserialize a tree.
    static SDBinaryTreeNode deSerialize(ArrayList<Integer> arr) {
        int[] i = {0};
        return deserializePreOrder(i, arr);
    }

    public static void main(String[] args) {

        //       10
        //     /    \
        //    20    30
        //  /   \
        // 40  60
        SDBinaryTreeNode root = new SDBinaryTreeNode(10);
        root.left = new SDBinaryTreeNode(20);
        root.right = new SDBinaryTreeNode(30);
        root.left.left = new SDBinaryTreeNode(40);
        root.left.right = new SDBinaryTreeNode(60);

        ArrayList<Integer> arr = serialize(root);
        SDBinaryTreeNode res = deSerialize(arr);
    }
}
