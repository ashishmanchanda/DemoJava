package blind250.binarytrees;
import java.util.ArrayList;

// Node Structure
class PostOrderNode {
    int data;
    PostOrderNode left;
    PostOrderNode right;

    PostOrderNode(int v) {
        data = v;
        left = null;
        right = null;
    }
}

 class PostOrder {
    static void postOrder(PostOrderNode node, ArrayList<Integer> res) {
        if (node == null)
            return;

        // First we traverse left subtree
        postOrder(node.left, res);

        // After visiting left, traverse right subtree
        postOrder(node.right, res);

        // now we visit node
        res.add(node.data);
    }

    public static void main(String[] args) {

        //Represent Tree
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);
        root.right = new PostOrderNode(3);
        root.left.left = new PostOrderNode(4);
        root.left.right = new PostOrderNode(5);
        root.right.right = new PostOrderNode(6);

        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root, result);

        // Print the postorder
        for (int val : result)
            System.out.print(val + " ");
    }
}