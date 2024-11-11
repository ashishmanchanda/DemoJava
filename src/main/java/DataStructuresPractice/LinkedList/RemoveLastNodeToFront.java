package DataStructuresPractice.LinkedList;

// Java Program to move last element
// to front in a given linked list

class RemoveLastNodeToFrontNode {
    int data;
    RemoveLastNodeToFrontNode next;

    RemoveLastNodeToFrontNode(int x) {
        data = x;
        next = null;
    }
}

class RemoveLastNodeToFront {

    // Function to move the last node to the
    // front of the linked list
    static RemoveLastNodeToFrontNode moveToFront(RemoveLastNodeToFrontNode head) {

        // If the list is empty or has only one node,
        // no need to move
        if (head == null || head.next == null) {
            return head;
        }

        // To keep track of the second last node
        RemoveLastNodeToFrontNode secLast = null;

        // To traverse to the last node
        RemoveLastNodeToFrontNode last = head;

        // Traverse the list to find the last and
        // second last nodes
        while (last.next != null) {
            secLast = last;
            last = last.next;
        }

        // Change the next of second last node to null
        secLast.next = null;

        // Make the last node as the new head
        last.next = head;
        head = last;

        return head;
    }

    static void printList(RemoveLastNodeToFrontNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a linked list 1->2->3->4->5
        RemoveLastNodeToFrontNode head = new RemoveLastNodeToFrontNode(1);
        head.next = new RemoveLastNodeToFrontNode(2);
        head.next.next = new RemoveLastNodeToFrontNode(3);
        head.next.next.next = new RemoveLastNodeToFrontNode(4);
        head.next.next.next.next = new RemoveLastNodeToFrontNode(5);

        System.out.println("Linked list before: ");
        printList(head);

        head = moveToFront(head);

        System.out.println("Linked list after: ");
        printList(head);
    }
}

