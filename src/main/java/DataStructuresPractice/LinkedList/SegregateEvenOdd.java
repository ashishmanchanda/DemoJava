package DataStructuresPractice.LinkedList;

class SegregateEvenOddNode {
    int data;
    SegregateEvenOddNode next;

    SegregateEvenOddNode(int x) {
        data = x;
        next = null;
    }
}

public class SegregateEvenOdd {

    // Function to segregate even and odd nodes
    // and return the head of the new list.
    public static SegregateEvenOddNode segregateEvenOdd(SegregateEvenOddNode head) {

        // We create dummy nodes to avoid extra
        // condition checks in the while loop.
        SegregateEvenOddNode eStart = new SegregateEvenOddNode(0);
        SegregateEvenOddNode oStart = new SegregateEvenOddNode(0);

        // Pointers to the end of the even and odd lists
        SegregateEvenOddNode eEnd = eStart;
        SegregateEvenOddNode oEnd = oStart;

        // Node to traverse the list
        SegregateEvenOddNode curr = head;

        while (curr != null) {
            int val = curr.data;

            // If current value is even, add it to the even list
            if (val % 2 == 0) {
                eEnd.next = curr;
                eEnd = eEnd.next;
            } else { // Else to the odd list
                oEnd.next = curr;
                oEnd = oEnd.next;
            }

            // Move to the next node
            curr = curr.next;
        }

        // Terminate the odd list
        oEnd.next = null;

        // Combine even and odd lists
        eEnd.next = oStart.next;

        // Return the new head of the combined list (even head)
        return eStart.next;
    }

    // Function to print the linked list
    public static void printList(SegregateEvenOddNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // Let us create a sample linked list as following
        // 0->1->4->6->9->10->11
        SegregateEvenOddNode head = new SegregateEvenOddNode(0);
        head.next = new SegregateEvenOddNode(1);
        head.next.next = new SegregateEvenOddNode(4);
        head.next.next.next = new SegregateEvenOddNode(6);
        head.next.next.next.next = new SegregateEvenOddNode(9);
        head.next.next.next.next.next = new SegregateEvenOddNode(10);
        head.next.next.next.next.next.next = new SegregateEvenOddNode(11);

        System.out.print("Original Linked list: ");
        printList(head);

        head = segregateEvenOdd(head);

        System.out.print("\nModified Linked list: ");
        printList(head);
    }
}
