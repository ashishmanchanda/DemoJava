package DS.BST;

// Java program to Merge Two Balanced Binary Search Trees
import java.io.*;
import java.util.ArrayList;

// A binary tree Merge2BSTNode
class Merge2BSTNode {

    int data;
    Merge2BSTNode left, right;

    Merge2BSTNode(int d) {
        data = d;
        left = right = null;
    }
}

class BinarySearchTree
{

    // Root of BST
    Merge2BSTNode root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Inorder traversal of the tree
    void inorder()
    {
        inorderUtil(this.root);
    }

    // Utility function for inorder traversal of the tree
    void inorderUtil(Merge2BSTNode Merge2BSTNode)
    {
        if(Merge2BSTNode==null)
            return;

        inorderUtil(Merge2BSTNode.left);
        System.out.print(Merge2BSTNode.data + " ");
        inorderUtil(Merge2BSTNode.right);
    }


    // A Utility Method that stores inorder traversal of a tree
    public ArrayList<Integer> storeInorderUtil(Merge2BSTNode Merge2BSTNode, ArrayList<Integer> list)
    {
        if(Merge2BSTNode == null)
            return list;

        //recur on the left child
        storeInorderUtil(Merge2BSTNode.left, list);

        // Adds data to the list
        list.add(Merge2BSTNode.data);

        //recur on the right child
        storeInorderUtil(Merge2BSTNode.right, list);

        return list;
    }

    // Method that stores inorder traversal of a tree
    ArrayList<Integer> storeInorder(Merge2BSTNode Merge2BSTNode)
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = storeInorderUtil(Merge2BSTNode,list1);
        return list2;
    }

    // Method that merges two ArrayLists into one.
    ArrayList<Integer> merge(ArrayList<Integer>list1, ArrayList<Integer>list2, int m, int n)
    {
        // list3 will contain the merge of list1 and list2
        ArrayList<Integer> list3 = new ArrayList<>();
        int i=0;
        int j=0;

        //Traversing through both ArrayLists
        while( i<m && j<n)
        {
            // Smaller one goes into list3
            if(list1.get(i)<list2.get(j))
            {
                list3.add(list1.get(i));
                i++;
            }
            else
            {
                list3.add(list2.get(j));
                j++;
            }
        }

        // Adds the remaining elements of list1 into list3
        while(i<m)
        {
            list3.add(list1.get(i));
            i++;
        }

        // Adds the remaining elements of list2 into list3
        while(j<n)
        {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }

    // Method that converts an ArrayList to a BST
    Merge2BSTNode ALtoBST(ArrayList<Integer>list, int start, int end)
    {
        // Base case
        if(start > end)
            return null;

        // Get the middle element and make it root	
        int mid = (start+end)/2;
        Merge2BSTNode Merge2BSTNode = new Merge2BSTNode(list.get(mid));

		/* Recursively construct the left subtree and make it
		left child of root */
        Merge2BSTNode.left = ALtoBST(list, start, mid-1);
		
		/* Recursively construct the right subtree and make it
		right child of root */
        Merge2BSTNode.right = ALtoBST(list, mid+1, end);

        return Merge2BSTNode;
    }

    // Method that merges two trees into a single one.
    Merge2BSTNode mergeTrees(Merge2BSTNode Merge2BSTNode1, Merge2BSTNode Merge2BSTNode2)
    {
        //Stores Inorder of tree1 to list1
        ArrayList<Integer>list1 = storeInorder(Merge2BSTNode1);

        //Stores Inorder of tree2 to list2
        ArrayList<Integer>list2 = storeInorder(Merge2BSTNode2);

        // Merges both list1 and list2 into list3
        ArrayList<Integer>list3 = merge(list1, list2, list1.size(), list2.size());

        //Eventually converts the merged list into resultant BST
        Merge2BSTNode Merge2BSTNode = ALtoBST(list3, 0, list3.size()-1);
        return Merge2BSTNode;
    }

    // Driver function
    public static void main (String[] args)
    {
		
		/* Creating following tree as First balanced BST
				100
				/ \
				50 300
				/ \
			20 70
		*/

        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.root = new Merge2BSTNode(100);
        tree1.root.left = new Merge2BSTNode(50);
        tree1.root.right = new Merge2BSTNode(300);
        tree1.root.left.left = new Merge2BSTNode(20);
        tree1.root.left.right = new Merge2BSTNode(70);
		
		/* Creating following tree as second balanced BST
				80
				/ \
			40 120
		*/

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = new Merge2BSTNode(80);
        tree2.root.left = new Merge2BSTNode(40);
        tree2.root.right = new Merge2BSTNode(120);


        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.mergeTrees(tree1.root, tree2.root);
        System.out.println("The Inorder traversal of the merged BST is: ");
        tree.inorder();
    }
}
// This code has been contributed by Kamal Rawal

