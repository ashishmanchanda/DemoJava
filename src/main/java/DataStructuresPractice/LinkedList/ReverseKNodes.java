package DataStructuresPractice.LinkedList;

// Java program to reverse a linked list in groups of
// given size

class ReverseNode {
    int data;
    ReverseNode next;

    ReverseNode(int x) {
        data = x;
        next = null;
    }
}

// Helper function to reverse K nodes
class GfG {

    static ReverseNode reverseKNodes(ReverseNode head, int k) {
        ReverseNode curr = head;
        ReverseNode prev = null;
        ReverseNode next = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        return prev;
    }

    // Recursive function to reverse in groups of K
    static ReverseNode reverseKGroup(ReverseNode head, int k) {
        if (head == null) {
            return head;
        }

        ReverseNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        ReverseNode groupHead = reverseKNodes(head, k);

        // Recursion for the next group
        head.next = reverseKGroup(temp, k);

        return groupHead;
    }

    static void printList(ReverseNode head) {
        ReverseNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating a sample singly linked list:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ReverseNode head = new ReverseNode(1);
        head.next = new ReverseNode(2);
        head.next.next = new ReverseNode(3);
        head.next.next.next = new ReverseNode(4);
        head.next.next.next.next = new ReverseNode(5);
        head.next.next.next.next.next = new ReverseNode(6);

        head = reverseKGroup(head, 3);
        printList(head);
    }
}

