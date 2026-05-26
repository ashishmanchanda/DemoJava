package striversheet.linkedlist;

// Java code to reverse a doubly linked 
// list in groups of K size

class ReverseDLLNode {
    int data;
    ReverseDLLNode next;
    ReverseDLLNode prev;

    ReverseDLLNode(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

// Helper function to reverse K ReverseDLLNodes
class ReverseDLLNodeGfG {
    static ReverseDLLNode reverseKReverseDLLNodes(ReverseDLLNode head, int k) {
        ReverseDLLNode curr = head, prev = null, next = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            curr.prev = null;
            if (prev != null) {
                prev.prev = curr;
            }
            prev = curr;
            curr = next;
            count++;
        }

        return prev;
    }

    // Recursive function to reverse in groups of K
    static ReverseDLLNode reverseKGroup(ReverseDLLNode head, int k) {
        if (head == null) {
            return head;
        }

        ReverseDLLNode groupHead = null;
        ReverseDLLNode newHead = null;

        // Move temp to the next group
        ReverseDLLNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // Reverse the first K ReverseDLLNodes
        groupHead = reverseKReverseDLLNodes(head, k);

        // Connect the reversed group with the next part
        if (newHead == null) {
            newHead = groupHead;
        }

        // Recursion for the next group
        head.next = reverseKGroup(temp, k);
        if (head.next != null) {
            head.next.prev = head;
        }

        return newHead;
    }

    // Function to print the doubly linked list
    static void printList(ReverseDLLNode head) {
        ReverseDLLNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating a sample doubly linked list:
        // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
        ReverseDLLNode head = new ReverseDLLNode(1);
        head.next = new ReverseDLLNode(2);
        head.next.prev = head;
        head.next.next = new ReverseDLLNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new ReverseDLLNode(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new ReverseDLLNode(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new ReverseDLLNode(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        head = reverseKGroup(head, 2);
        printList(head);
    }
}