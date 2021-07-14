package DS.Tree;

// Java program to delete a tree

//import apple.laf.JRSUIUtils;

/* A binary tree node has data, pointer to left child
and pointer to right child */
class TreeNode1
{
    int  data;
    TreeNode1 left, right;

    TreeNode1(int d)
    {
        data = d;
        left = right = null;
    }
}

class DeleteBinaryTree
{

    static TreeNode1 root;

    /* This function is same as deleteTree() in the previous program */
    void deleteTreeRef(TreeNode1 treeNode)
    {
        // In Java automatic garbage collection
        // happens, so we can simply make root
        // null to delete the tree
        root = null;
    }

    /* Wrapper function that deletes the tree and
    sets root node as null */
    void deleteTree(TreeNode1 treeNodeRef)
    {
        deleteTreeRef(treeNodeRef);
        treeNodeRef =null;
    }

    /* Driver program to test deleteTree function */
    public static void main(String[] args)
    {

        DeleteBinaryTree tree = new DeleteBinaryTree();

        tree.root = new TreeNode1(1);
        tree.root.left = new TreeNode1(2);
        tree.root.right = new TreeNode1(3);
        tree.root.left.left = new TreeNode1(4);
        tree.root.left.right = new TreeNode1(5);

		/* Note that we pass root node here */
        tree.deleteTree(root);
        System.out.println("Tree deleted");

    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)
