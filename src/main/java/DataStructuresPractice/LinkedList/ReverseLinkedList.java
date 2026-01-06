package DataStructuresPractice.LinkedList;
// Iterative Java program to reverse a linked list

class Node {
    int data;
    ReverseNode next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Given the head of a list, reverse the list and return the
// head of reversed list
public class ReverseLinkedList {
    static ReverseNode reverseList(ReverseNode head) {

        // Initialize three pointers: curr, prev and next
        ReverseNode curr = head, prev = null, next;

        // Traverse all the nodes of Linked List
        while (curr != null) {

            // Store next
            next = curr.next;

            // Reverse current node's next pointer
            curr.next = prev;

            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }

        // Return the head of reversed linked list
        return prev;
    }

    // This function prints the contents
    // of the linked list starting from the head
    static void printList(ReverseNode node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        ReverseNode head = new ReverseNode(1);
        head.next = new ReverseNode(2);
        head.next.next = new ReverseNode(3);
        head.next.next.next = new ReverseNode(4);
        head.next.next.next.next = new ReverseNode(5);

        System.out.print("Given Linked list:");
        printList(head);

        head = reverseList(head);

        System.out.print("\nReversed Linked List:");
        printList(head);
    }
}

