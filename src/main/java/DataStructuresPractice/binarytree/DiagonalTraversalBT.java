package DataStructuresPractice.binarytree;

// Java program to print diagonal view
import java.util.*;

class DiagonalTraversalBTNode {
    int data;
    DiagonalTraversalBTNode left, right;

    DiagonalTraversalBTNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class DiagonalTraversalBT {

    // Recursive function to print diagonal view
    static void diagonalRecur(DiagonalTraversalBTNode root, int level,
                              HashMap<Integer, ArrayList<Integer> > levelData) {

        // Base case
        if (root == null)
            return;

        // Append the current node into hash map.
        levelData.computeIfAbsent
                (level, k -> new ArrayList<>()).add(root.data);

        // Recursively traverse the left subtree.
        diagonalRecur(root.left, level + 1, levelData);

        // Recursively traverse the right subtree.
        diagonalRecur(root.right, level, levelData);
    }

    // function to print diagonal view
    static ArrayList<Integer> diagonal(DiagonalTraversalBTNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Create a hash map to store each
        // node at its respective level.
        HashMap<Integer, ArrayList<Integer> > levelData = new HashMap<>();
        diagonalRecur(root, 0, levelData);

        int level = 0;

        // Insert into answer level by level.
        while (levelData.containsKey(level)) {
            ArrayList<Integer> v = levelData.get(level);
            ans.addAll(v);
            level++;
        }

        return ans;
    }

    static void printList(ArrayList<Integer> v) {
        for (int val : v) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard coded tree
        //         8
        //       /   \
        //     3      10
        //    /      /  \
        //   1      6    14
        //         / \   /
        //        4   7 13
        DiagonalTraversalBTNode root = new DiagonalTraversalBTNode(8);
        root.left = new DiagonalTraversalBTNode(3);
        root.right = new DiagonalTraversalBTNode(10);
        root.left.left = new DiagonalTraversalBTNode(1);
        root.right.left = new DiagonalTraversalBTNode(6);
        root.right.right = new DiagonalTraversalBTNode(14);
        root.right.right.left = new DiagonalTraversalBTNode(13);
        root.right.left.left = new DiagonalTraversalBTNode(4);
        root.right.left.right = new DiagonalTraversalBTNode(7);

        ArrayList<Integer> ans = diagonal(root);
        printList(ans);
    }
}