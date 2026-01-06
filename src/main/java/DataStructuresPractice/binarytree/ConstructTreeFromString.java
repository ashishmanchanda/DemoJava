package DataStructuresPractice.binarytree;

class ConstructTreeFromString {

    // Node class for the Tree
    static class Node
    {
        int data;
        Node left,right;

        Node(int data)
        {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // static variable to point to the
// starting index of the string.
    static int start = 0;

    // Construct Tree Function which accepts
// a string and return root of the tree;
    static Node constructTree(String s)
    {

        // Check for null or empty string
        // and return null;
        if (s.length() == 0 || s == null)
        {
            return null;
        }

        if (start >= s.length())
            return null;

        // Boolean variable to check
        // for negative numbers
        boolean neg = false;

        // Condition to check for negative number
        if (s.charAt(start) == '-')
        {
            neg = true;
            start++;
        }

        // This loop basically construct the
        // number from the continuous digits
        int num = 0;
        while (start < s.length() &&
                Character.isDigit(s.charAt(start)))
        {
            int digit = Character.getNumericValue(
                    s.charAt(start));
            num = num * 10 + digit;
            start++;
        }

        // If string contains - minus sign
        // then append - to the number;
        if (neg)
            num = -num;

        // Create the node object i.e. root of
        // the tree with data = num;
        Node node = new Node(num);

        if (start >= s.length())
        {
            return node;
        }

        // Check for open bracket and add the
        // data to the left subtree recursively
        if (start < s.length() && s.charAt(start) == '(' )
        {
            start++;
            node.left = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')')
        {
            start++;
            return node;
        }

        // Check for open bracket and add the data
        // to the right subtree recursively
        if (start < s.length() && s.charAt(start) == '(')
        {
            start++;
            node.right = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')')
        {
            start++;
            return node;
        }
        return node;
    }

    // Print tree function
    public static void printTree(Node node)
    {
        if (node == null)
            return;

        System.out.println(node.data + " ");
        printTree(node.left);
        printTree(node.right);
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Input
        String s = "4(2(3)(1))(6(5))";

        // Call the function construct tree
        // to create the tree pass the string;
        Node root = constructTree(s);

        // Function to print preorder of the tree
        printTree(root);
    }
}

// This code is contributed by yash181999

