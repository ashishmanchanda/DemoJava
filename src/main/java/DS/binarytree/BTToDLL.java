package DS.binarytree;
// A Java program for in-place conversion of Binary Tree to DLL

// A binary tree BTLLNode has data, left pointers and right pointers
class BTLLNode
{
    int data;
    BTLLNode left, right;

    public BTLLNode(int data)
    {
        this.data = data;
        left = right = null;
    }
}

class BTBTBinaryTree
{
    BTLLNode root;

    // head --> Pointer to head BTLLNode of created doubly linked list
    BTLLNode head;

    // Initialize previously visited BTLLNode as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static BTLLNode prev = null;

    // A simple recursive function to convert a given Binary tree
    // to Doubly Linked List
    // root --> Root of Binary Tree
    void BTBTBinaryTree2DoubleLinkedList(BTLLNode root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BTBTBinaryTree2DoubleLinkedList(root.left);

        // Now convert this BTLLNode
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        BTBTBinaryTree2DoubleLinkedList(root.right);
    }

    /* Function to print BTLLNodes in a given doubly linked list */
    void printList(BTLLNode BTLLNode)
    {
        while (BTLLNode != null)
        {
            System.out.print(BTLLNode.data + " ");
            BTLLNode = BTLLNode.right;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BTBTBinaryTree tree = new BTBTBinaryTree();
        tree.root = new BTLLNode(10);
        tree.root.left = new BTLLNode(12);
        tree.root.right = new BTLLNode(15);
        tree.root.left.left = new BTLLNode(25);
        tree.root.left.right = new BTLLNode(30);
        tree.root.right.left = new BTLLNode(36);

        // convert to DLL
        tree.BTBTBinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }
}
// This code has been contributed by Mayank Jaiswal(mayank_24)

