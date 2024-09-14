package DS.binarytree;



/*Print Ancestors of a given node in Binary Tree*/


  /*  1
    2  3
   4 5  6
     7*/

import java.util.*;

class ProblemNode {
    int data;
    ProblemNode left;
    ProblemNode right;
    public ProblemNode(int data) {
        this.data = data;
    }

}

public class TopView {



    public static void main(String[] args) {

        List<ProblemNode> result = new ArrayList<>();
        ProblemNode root = buildList();
        int target = 7;
        List<List<ProblemNode>> levelNodes = buildList(root, target);

        List<ProblemNode> lastList = levelNodes.get(levelNodes.size() - 1);
        ProblemNode targetNode = lastList.get(lastList.size()-1);
        for(int i = levelNodes.size() - 2; i >= 0; i-- ) {
            List<ProblemNode> tempList = levelNodes.get(i);
            for(int j = 0; j < tempList.size(); j++) {
                ProblemNode temp = tempList.get(j);
                if(targetNode == temp.left || targetNode == temp.right) {
                    result.add(temp);
                    targetNode = temp;
                    break;
                }
            }
        }
        for(ProblemNode node : result) {
            System.out.print(node.data + " ");
        }

    }

    public static ProblemNode buildList() {
        ProblemNode node = new ProblemNode(1);
        node.left = new ProblemNode(2);
        node.right = new ProblemNode(3);
        node.left.left = new ProblemNode(4);
        node.left.right = new ProblemNode(5);
        node.right.right = new ProblemNode(6);
        node.left.left.left = new ProblemNode(7);
        return node;
    }

    public static List<List<ProblemNode>> buildList(ProblemNode node, int target) {
        List<List<ProblemNode>> levelNodes = new ArrayList<>();
        Queue<ProblemNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            List<ProblemNode> list = new LinkedList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                ProblemNode temp = q.remove();
                list.add(temp);
                if(temp.data == target) {
                    return levelNodes;
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            levelNodes.add(list);
        }
        return levelNodes;
    }
}


//
//// Java program to print top
//// view of binary tree
//import java.util.*;
//
//class GFG {
//
//    // Structure of binary tree
//    static class Node {
//        Node left;
//        Node right;
//        int data;
//    }
//
//    static class pair {
//        int first, second;
//
//        pair() {}
//        pair(int i, int j)
//        {
//            first = i;
//            second = j;
//        }
//    }
//
//    // map to store the pair of node value and
//    // its level with respect to the vertical
//    // distance from root.
//    static TreeMap<Integer, pair> m = new TreeMap<>();
//
//    // function to create a new node
//    static Node newNode(int key)
//    {
//        Node node = new Node();
//        node.left = node.right = null;
//        node.data = key;
//        return node;
//    }
//
//    // function to fill the map
//    static void fillMap(Node root, int d, int l)
//    {
//        if (root == null)
//            return;
//
//        if (m.get(d) == null) {
//            m.put(d, new pair(root.data, l));
//        }
//        else if (m.get(d).second > l) {
//            m.put(d, new pair(root.data, l));
//        }
//
//        fillMap(root.left, d - 1, l + 1);
//        fillMap(root.right, d + 1, l + 1);
//    }
//
//    // function should print the topView of
//    // the binary tree
//    static void topView(Node root)
//    {
//        fillMap(root, 0, 0);
//
//        for (Map.Entry<Integer, pair> entry :
//                m.entrySet()) {
//            System.out.print(entry.getValue().first + " ");
//        }
//    }
//
//    // Driver Code
//    public static void main(String args[])
//    {
//        Node root = newNode(1);
//        root.left = newNode(2);
//        root.right = newNode(3);
//        root.left.right = newNode(4);
//        root.left.right.right = newNode(5);
//        root.left.right.right.right = newNode(6);
//        System.out.println("Following are nodes in"
//                + " top view of Binary Tree");
//        topView(root);
//    }
//}
//
//// This code is contributed by Arnab Kundu
//
