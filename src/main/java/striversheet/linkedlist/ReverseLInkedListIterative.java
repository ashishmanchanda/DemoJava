package striversheet.linkedlist;

class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int new_data) {
        data = new_data;
        next = null;
    }
}

class GfG {
    static LinkedListNode reverseList(LinkedListNode head) {

        LinkedListNode curr = head, prev = null, next;

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

        return prev;
    }

    static void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
    }

    public static void main(String[] args){

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        head = reverseList(head);
        printList(head);
    }
}
