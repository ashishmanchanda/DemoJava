package DataStructuresPractice.binarytree;

// Java program to find if there is a duplicate
// sub-tree of size 2 or more.

import java.util.HashMap;

class DuplicateSubTreeN2 {
    char data;
    DuplicateSubTreeN2 left, right;

    DuplicateSubTreeN2(char x) {
        data = x;
        left = null;
        right = null;
    }
}

class Duplicate {

    static String dupSubRecur(DuplicateSubTreeN2 root,
                              HashMap<String, Integer> map) {

        // For null nodes,
        if (root == null) return "N";

        // For leaf nodes, return its value in string.
        if (root.left == null && root.right == null) {
            return String.valueOf(root.data);
        }

        // Process the left and right subtree.
        String left = dupSubRecur(root.left, map);
        String right = dupSubRecur(root.right, map);

        // Generate the serialized form.
        String curr = "";
        curr += root.data;
        curr += '*';
        curr += left;
        curr += '*';
        curr += right;

        // Store the subtree in map.
        map.put(curr, map.getOrDefault(curr, 0) + 1);

        return curr;
    }

    static int dupSub(DuplicateSubTreeN2 root) {
        HashMap<String, Integer> map = new HashMap<>();

        // Generate all the subtrees.
        dupSubRecur(root, map);

        // Check for all subtrees.
        for (int val : map.values()) {

            // If subtree is duplicate.
            if (val > 1) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        //         A
        //       /   \
        //      B     C
        //     / \     \
        //    D   E     B
        //           /   \
        //          D     E
        DuplicateSubTreeN2 root = new DuplicateSubTreeN2('A');
        root.left = new DuplicateSubTreeN2('B');
        root.right = new DuplicateSubTreeN2('C');
        root.left.left = new DuplicateSubTreeN2('D');
        root.left.right = new DuplicateSubTreeN2('E');
        root.right.right = new DuplicateSubTreeN2('B');
        root.right.right.left = new DuplicateSubTreeN2('D');
        root.right.right.right = new DuplicateSubTreeN2('E');

        if (dupSub(root) == 1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
