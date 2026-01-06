package DataStructuresPractice.bst;

import java.util.*;

// Node of the binary tree
class FlattenBSToListImpl {
    int data;
    FlattenBSToListImpl left;
    FlattenBSToListImpl right;

    public FlattenBSToListImpl(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

 class FlattenBSToList {
    // Function to print flattened binary tree
    static void print(FlattenBSToListImpl parent)
    {
        FlattenBSToListImpl curr = parent;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    // Function to perform in-order traversal recursively
    static void inorder(List<Integer> traversal,
                        FlattenBSToListImpl parent)
    {
        // Base Case
        if (parent == null)
            return;

        inorder(traversal, parent.left);
        // Storing the values in the list
        traversal.add(parent.data);

        inorder(traversal, parent.right);
    }

    static void form(int pos, List<Integer> traversal,
                     FlattenBSToListImpl[] prev)
    {
        // Base Case
        if (pos == traversal.size())
            return;

        prev[0].right = new FlattenBSToListImpl(traversal.get(pos));
        prev[0].left = null;

        prev[0] = prev[0].right;

        // Calling for the next element of the list
        form(pos + 1, traversal, prev);
    }

    // Function to flatten binary tree using level order
    // traversal
    static FlattenBSToListImpl flatten(FlattenBSToListImpl parent)
    {
        // Dummy node
        FlattenBSToListImpl dummy = new FlattenBSToListImpl(-1);

        // Pointer to previous element
        FlattenBSToListImpl[] prev = { dummy };

        // List to store the inorder traversal of the binary
        // tree
        List<Integer> traversal = new ArrayList<>();
        inorder(traversal, parent);

        // forming the sorted list from the list obtained
        form(0, traversal, prev);

        prev[0].left = null;
        prev[0].right = null;
        FlattenBSToListImpl ret = dummy.right;

        // Delete dummy node
        dummy = null;
        return ret;
    }

    public static void main(String[] args)
    {
        FlattenBSToListImpl root = new FlattenBSToListImpl(5);
        root.left = new FlattenBSToListImpl(3);
        root.right = new FlattenBSToListImpl(7);
        root.left.left = new FlattenBSToListImpl(2);
        root.left.right = new FlattenBSToListImpl(4);
        root.right.left = new FlattenBSToListImpl(6);
        root.right.right = new FlattenBSToListImpl(8);

        // Calling required function
        print(flatten(root));
    }
}
