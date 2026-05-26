package striversheet.linkedlist;

// Java program to reverse a linked list in groups of
// given size

class ReverseKGroupNode {
    int data;
    ReverseKGroupNode next;

    ReverseKGroupNode(int x) {
        data = x;
        next = null;
    }
}

// Helper function to reverse K ReverseKGroupNodes
class ReverseKGroupGfG {

    static ReverseKGroupNode reverseKReverseKGroupNodes(ReverseKGroupNode head, int k) {
        ReverseKGroupNode curr = head;
        ReverseKGroupNode prev = null;
        ReverseKGroupNode next = null;
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
    static ReverseKGroupNode reverseKGroup(ReverseKGroupNode head, int k) {
        if (head == null) {
            return head;
        }

        ReverseKGroupNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        ReverseKGroupNode groupHead = reverseKReverseKGroupNodes(head, k);

        // Recursion for the next group
        head.next = reverseKGroup(temp, k);

        return groupHead;
    }

    static void printList(ReverseKGroupNode head) {
        ReverseKGroupNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating a sample singly linked list:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ReverseKGroupNode head = new ReverseKGroupNode(1);
        head.next = new ReverseKGroupNode(2);
        head.next.next = new ReverseKGroupNode(3);
        head.next.next.next = new ReverseKGroupNode(4);
        head.next.next.next.next = new ReverseKGroupNode(5);
        head.next.next.next.next.next = new ReverseKGroupNode(6);

        head = reverseKGroup(head, 3);
        printList(head);
    }
}