package DataStructuresPractice.bst;

// Java program to find the pairs with
// sum equal to x.
import java.util.Stack;

class PairSumX {
    int data;
    PairSumX left, right;

    PairSumX(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class PairSumXImpl {

    // Function to count pairs with sum equal to x
    static int countPairs(PairSumX root1, PairSumX root2, int x) {

        // if either of the tree is empty
        if (root1 == null || root2 == null)
            return 0;

        // stack 'st1' used for the inorder
        // traversal of BST 1
        // stack 'st2' used for the reverse
        // inorder traversal of BST 2
        Stack<PairSumX> st1 = new Stack<>();
        Stack<PairSumX> st2 = new Stack<>();
        PairSumX top1, top2;

        int count = 0;

        // the loop will break when either of two
        // traversals gets completed
        while (true) {

            // to find next node in inorder
            // traversal of BST 1
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }

            // to find next node in reverse
            // inorder traversal of BST 2
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }

            // if either gets empty then corresponding
            // tree traversal is completed
            if (st1.isEmpty() || st2.isEmpty())
                break;

            top1 = st1.peek();
            top2 = st2.peek();

            // if the sum of the node's is equal to 'x'
            if ((top1.data + top2.data) == x) {
                count++;

                // pop nodes from the respective stacks
                st1.pop();
                st2.pop();

                // insert next possible node in the
                // respective stacks
                root1 = top1.right;
                root2 = top2.left;
            }

            // move to next possible node in the
            // inorder traversal of BST 1
            else if ((top1.data + top2.data) < x) {
                st1.pop();
                root1 = top1.right;
            }

            // move to next possible node in the
            // reverse inorder traversal of BST 2
            else {
                st2.pop();
                root2 = top2.left;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // BST1
        //    2
        //  /  \
        // 1   3
        PairSumX root1 = new PairSumX(2);
        root1.left = new PairSumX(1);
        root1.right = new PairSumX(3);

        // BST2
        //    5
        //  /  \
        // 4   6
        PairSumX root2 = new PairSumX(5);
        root2.left = new PairSumX(4);
        root2.right = new PairSumX(6);

        int x = 6;
        System.out.println(countPairs(root1, root2, x));
    }
}
