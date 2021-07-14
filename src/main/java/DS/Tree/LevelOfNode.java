package DS.Tree;

    class Node2
    {
        int data;
        Node2 left, right;

        public Node2(int d)
        {
            data = d;
            left = right = null;
        }
    }

    class BinaryTree2
    {

        Node2 root;

        /* Helper function for getLevel(). It returns level of the data
        if data is present in tree, otherwise returns 0.*/
        int getLevelUtil(Node2 node, int data, int level)
        {
            if (node == null)
                return 0;

            if (node.data == data)
                return level;

            int downlevel = getLevelUtil(node.left, data, level + 1);
            if (downlevel != 0)
                return downlevel;

            downlevel = getLevelUtil(node.right, data, level + 1);
            return downlevel;
        }

        /* Returns level of given data value */
        int getLevel(Node2 node, int data)
        {
            return getLevelUtil(node, data, 1);
        }

        /* Driver function to test above functions */
        public static void main(String[] args)
        {
            BinaryTree2 tree = new BinaryTree2();

		/* Constructing tree given in the above figure */
            tree.root = new Node2(3);
            tree.root.left = new Node2(2);
            tree.root.right = new Node2(5);
            tree.root.left.left = new Node2(1);
            tree.root.left.right = new Node2(4);
            for (int x = 1; x <= 5; x++)
            {
                int level = tree.getLevel(tree.root, x);
                if (level != 0)
                    System.out.println("Level of " + x + " is "
                            + tree.getLevel(tree.root, x));
                else
                    System.out.println(x + " is not present in tree");
            }
        }
    }

    // This code has been contributed by Mayank Jaiswal(mayank_24)


