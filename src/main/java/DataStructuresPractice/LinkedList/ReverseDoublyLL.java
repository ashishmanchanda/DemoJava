package DataStructuresPractice.LinkedList;

// Java code to Reverse a doubly linked list,
// using two pointers
class ReverseDoublyLLNode {
    int data;
    ReverseDoublyLLNode next;
    ReverseDoublyLLNode prev;

    ReverseDoublyLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class ReverseDoublyLL {

    // Function to reverse a Doubly Linked List using two
    // pointers
    static ReverseDoublyLLNode reverse(ReverseDoublyLLNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ReverseDoublyLLNode currNode = head;
        ReverseDoublyLLNode prevNode = null;

        // Traverse the list and reverse the links
        while (currNode != null) {

            // Swap the next and prev pointers
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;

            // Move to the next node in the original list
            // (which is now previous due to reversal)
            currNode = currNode.prev;
        }

        // Update head of Doubly Linked List
        head = prevNode.prev;

        return head;
    }

    static void printList(ReverseDoublyLLNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a doubly linked list:
        // 1 <-> 2 <-> 3 <-> 4
        ReverseDoublyLLNode head = new ReverseDoublyLLNode(1);
        head.next = new ReverseDoublyLLNode(2);
        head.next.prev = head;
        head.next.next = new ReverseDoublyLLNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new ReverseDoublyLLNode(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Original Doubly Linked List");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed Doubly Linked List");
        printList(head);
    }
}

