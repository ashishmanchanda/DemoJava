package striversheet.linkedlist;

// Java Program to move last element
// to front in a given linked list

class MoveLastNodeToFront {
    int data;
    MoveLastNodeToFront next;

    MoveLastNodeToFront(int x) {
        data = x;
        next = null;
    }
}

class MoveLastNodeToFrontGfG {

    // Function to move the last MoveLastNodeToFront to the 
    // front of the linked list
    static MoveLastNodeToFront moveToFront(MoveLastNodeToFront head) {

        // If the list is empty or has only one MoveLastNodeToFront, 
        // no need to move
        if (head == null || head.next == null) {
            return head;
        }

        // To keep track of the second last MoveLastNodeToFront
        MoveLastNodeToFront secLast = null;

        // To traverse to the last MoveLastNodeToFront
        MoveLastNodeToFront last = head;

        // Traverse the list to find the last and 
        // second last MoveLastNodeToFronts
        while (last.next != null) {
            secLast = last;
            last = last.next;
        }

        // Change the next of second last MoveLastNodeToFront to null
        secLast.next = null;

        // Make the last MoveLastNodeToFront as the new head
        last.next = head;
        head = last;

        return head;
    }

    static void printList(MoveLastNodeToFront MoveLastNodeToFront) {
        while (MoveLastNodeToFront != null) {
            System.out.print(MoveLastNodeToFront.data + " ");
            MoveLastNodeToFront = MoveLastNodeToFront.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a linked list 1->2->3->4->5
        MoveLastNodeToFront head = new MoveLastNodeToFront(1);
        head.next = new MoveLastNodeToFront(2);
        head.next.next = new MoveLastNodeToFront(3);
        head.next.next.next = new MoveLastNodeToFront(4);
        head.next.next.next.next = new MoveLastNodeToFront(5);

        System.out.println("Linked list before: ");
        printList(head);

        head = moveToFront(head);

        System.out.println("Linked list after: ");
        printList(head);
    }
}
