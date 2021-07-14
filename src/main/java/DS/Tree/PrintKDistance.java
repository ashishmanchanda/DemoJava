package DS.Tree;

// Java program to print nodes at k distance from root

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class Node
{
    int       data;
    NodeLevel left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree1
{
    NodeLevel root;

    void printKDistant(NodeLevel treeNode, int k)
    {
        if (treeNode == null)
            return;
        if (k == 0)
        {
            System.out.print(treeNode.data + " ");
            return;
        }
        else
        {
            printKDistant(treeNode.left, k - 1);
            printKDistant(treeNode.right, k - 1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree1 tree = new BinaryTree1();

		/* Constructed binary tree is
				1
			/ \
			2	 3
			/ \ /
		4 5 8
		*/
        tree.root = new NodeLevel(1);
        tree.root.left = new NodeLevel(2);
        tree.root.right = new NodeLevel(3);
        tree.root.left.left = new NodeLevel(4);
        tree.root.left.right = new NodeLevel(5);
        tree.root.right.left = new NodeLevel(8);

        tree.printKDistant(tree.root, 2);
    }
}

// This code has been contributed by Mayank Jaiswal

