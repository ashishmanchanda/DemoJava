package DataStructuresPractice.bst;

// Java program to find the predecessor and
// successor of a given key in a BST
class PredSuccessor {
    int data;
    PredSuccessor left, right;
    PredSuccessor(int x) {
        data = x;
        left = right = null;
    }
}

class PredSuccessorImpl {

    // Function to find the maximum value in the
    // left subtree (Predecessor)
    static PredSuccessor rightMost(PredSuccessor node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Function to find the minimum value
    // in the right subtree (Successor)
    static PredSuccessor leftMost(PredSuccessor node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // This function finds predecessor and successor of key
    // in BST. It sets pre and suc as predecessor and
    // successor respectively using an iterative approach.
    static void findPreSuc(PredSuccessor root, PredSuccessor[] pre,
                           PredSuccessor[] suc, int key) {
        PredSuccessor curr = root;

        while (curr != null) {
            if (curr.data < key) {
                pre[0] = curr;
                curr = curr.right;
            }
            else if (curr.data > key) {
                suc[0] = curr;
                curr = curr.left;
            }
            else {

                // Find the predecessor (maximum value in
                // the left subtree)
                if (curr.left != null)
                    pre[0] = rightMost(curr.left);

                // Find the successor (minimum value in the
                // right subtree)
                if (curr.right != null)
                    suc[0] = leftMost(curr.right);
                break;
            }
        }
    }
    public static void main(String[] args) {
        int key = 65;

        // Let us create the following BST
        //          50
        //       /     \
        //      30      70
        //     /  \    /  \
        //   20   40  60   80
        PredSuccessor root = new PredSuccessor(50);
        root.left = new PredSuccessor(30);
        root.right = new PredSuccessor(70);
        root.left.left = new PredSuccessor(20);
        root.left.right = new PredSuccessor(40);
        root.right.right = new PredSuccessor(80);
        root.right.left = new PredSuccessor(60);

        PredSuccessor[] pre = new PredSuccessor[1];
        PredSuccessor[] suc = new PredSuccessor[1];

        findPreSuc(root, pre, suc, key);

        if (pre[0] != null)
            System.out.println("Predecessor is: " + pre[0].data);
        else
            System.out.println("No Predecessor");

        if (suc[0] != null)
            System.out.println("Successor is: " + suc[0].data);
        else
            System.out.println("No Successor");
    }
}