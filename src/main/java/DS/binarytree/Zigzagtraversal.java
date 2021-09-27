package DS.binarytree;

// Java implementation of a O(n) time
// method for Zigzag order traversal
import java.util.*;

// Binary Tree ZigzagNode
class ZigzagNode
{
    int data;
    ZigzagNode leftChild;
    ZigzagNode rightChild;
    ZigzagNode(int data)
    {
        this.data = data;
    }
}

class ZigzagBT {
    ZigzagNode rootZigzagNode;

    // function to print the
    // zigzag traversal
    void printZigZagTraversal() {

        // if null then return
        if (rootZigzagNode == null) {
            return;
        }

        // declare two stacks
        Stack<ZigzagNode> currentLevel = new Stack<>();
        Stack<ZigzagNode> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootZigzagNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            ZigzagNode ZigzagNode = currentLevel.pop();

            // print the data in it
            System.out.print(ZigzagNode.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (ZigzagNode.leftChild != null) {
                    nextLevel.push(ZigzagNode.leftChild);
                }

                if (ZigzagNode.rightChild != null) {
                    nextLevel.push(ZigzagNode.rightChild);
                }
            }
            else {
                if (ZigzagNode.rightChild != null) {
                    nextLevel.push(ZigzagNode.rightChild);
                }

                if (ZigzagNode.leftChild != null) {
                    nextLevel.push(ZigzagNode.leftChild);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<ZigzagNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
}

 class zigZagTreeTraversal {

    // driver program to test the above function
    public static void main(String[] args)
    {
        ZigzagBT tree = new ZigzagBT();
        tree.rootZigzagNode = new ZigzagNode(1);
        tree.rootZigzagNode.leftChild = new ZigzagNode(2);
        tree.rootZigzagNode.rightChild = new ZigzagNode(3);
        tree.rootZigzagNode.leftChild.leftChild = new ZigzagNode(7);
        tree.rootZigzagNode.leftChild.rightChild = new ZigzagNode(6);
        tree.rootZigzagNode.rightChild.leftChild = new ZigzagNode(5);
        tree.rootZigzagNode.rightChild.rightChild = new ZigzagNode(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}

// This Code is contributed by Harikrishnan Rajan.

