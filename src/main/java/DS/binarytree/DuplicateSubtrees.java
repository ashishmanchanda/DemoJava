package DS.binarytree;


// Java program to find if there is a duplicate
// sub-tree of size 2 or more.
import java.util.HashSet;
 class Main111 {

    static char MARKER = '$';

    // This function returns empty string if tree
    // contains a duplicate subtree of size 2 or more.
    public static String dupSubUtil(NodeDuplicate root, HashSet<String> subtrees)
    {
        String s = "";

        // If current NodeDuplicate is NULL, return marker
        if (root == null)
            return s + MARKER;

        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left,subtrees);
        if (lStr.equals(s))
            return s;

        // Do same for right subtree
        String rStr = dupSubUtil(root.right,subtrees);
        if (rStr.equals(s))
            return s;

        // Serialize current subtree
        s = s + root.data + lStr + rStr;

        // If current subtree already exists in hash
        // table. [Note that size of a serialized tree
        // with single NodeDuplicate is 3 as it has two marker
        // NodeDuplicates.
        if (s.length() > 3 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }

    //Function to find if the Binary Tree contains duplicate
    //subtrees of size 2 or more
    public static String dupSub(NodeDuplicate root)
    {
        HashSet<String> subtrees=new HashSet<>();
        return dupSubUtil(root,subtrees);
    }

    public static void main(String args[])
    {
        NodeDuplicate root = new NodeDuplicate('A');
        root.left = new NodeDuplicate('B');
        root.right = new NodeDuplicate('C');
        root.left.left = new NodeDuplicate('D');
        root.left.right = new NodeDuplicate('E');
        root.right.right = new NodeDuplicate('B');
        root.right.right.right = new NodeDuplicate('E');
        root.right.right.left= new NodeDuplicate('D');
        String str = dupSub(root);
        if(str.equals(""))
            System.out.print(" Yes ");
        else
            System.out.print(" No ");
    }
}

// A binary tree NodeDuplicate has data,
// pointer to left child
// and a pointer to right child
class NodeDuplicate {
    int data;
    NodeDuplicate left,right;
    NodeDuplicate(int data)
    {
        this.data=data;
    }
};
//This code is contributed by Gaurav Tiwari
