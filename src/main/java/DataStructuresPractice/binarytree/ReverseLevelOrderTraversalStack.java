package DataStructuresPractice.binarytree;

// Java program to print reverse level
// order traversal using stack and queue
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ReverseLevelOrderTraversalStack {
    int data;
    ReverseLevelOrderTraversalStack left, right;

    ReverseLevelOrderTraversalStack(int x) {
        data = x;
        left = right = null;
    }
}

class ReverseLevelOrderTraversalStackImpl {

    // Function to print REVERSE level order traversal of a tree
    static void reverseLevelOrder(ReverseLevelOrderTraversalStack root) {
        Stack<ReverseLevelOrderTraversalStack> st = new Stack<>();
        Queue<ReverseLevelOrderTraversalStack> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            // Dequeue node
            ReverseLevelOrderTraversalStack curr = q.poll();
            st.push(curr);

            // Enqueue right child
            if (curr.right != null)
                q.add(curr.right);

            // Enqueue left child
            if (curr.left != null)
                q.add(curr.left);
        }

        // Pop all items from stack one by one and print them
        while (!st.isEmpty()) {
            ReverseLevelOrderTraversalStack curr = st.pop();
            System.out.print(curr.data + " ");
        }
    }

    public static void main(String[] args) {

        // Create hard coded tree
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        ReverseLevelOrderTraversalStack root = new ReverseLevelOrderTraversalStack(1);
        root.left = new ReverseLevelOrderTraversalStack(2);
        root.right = new ReverseLevelOrderTraversalStack(3);
        root.left.left = new ReverseLevelOrderTraversalStack(4);
        root.left.right = new ReverseLevelOrderTraversalStack(5);

        reverseLevelOrder(root);
    }
}