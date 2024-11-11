package DataStructuresPractice.LinkedList;

// Java program to remove duplicates
// from a sorted linked list

class RemoveDuplicatesFromSortedLLNode {
    int data;
    RemoveDuplicatesFromSortedLLNode next;
    RemoveDuplicatesFromSortedLLNode(int x) {
        data = x;
        next = null;
    }
}

class RemoveDuplicatesFromSortedLL {

    // Function to remove duplicates
    static RemoveDuplicatesFromSortedLLNode removeDuplicates(RemoveDuplicatesFromSortedLLNode head) {
        RemoveDuplicatesFromSortedLLNode curr = head;

        // Traverse the list
        while (curr != null && curr.next != null) {

            // Check if next value is the same as curr
            if (curr.data == curr.next.data) {
                RemoveDuplicatesFromSortedLLNode nextNext = curr.next.next;
                curr.next = nextNext;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }

    static void printList(RemoveDuplicatesFromSortedLLNode removeDuplicatesFromSortedLL) {
        while (removeDuplicatesFromSortedLL != null) {
            System.out.print(removeDuplicatesFromSortedLL.data + " ");
            removeDuplicatesFromSortedLL = removeDuplicatesFromSortedLL.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a sorted linked list:
        // 11->11->11->13->13->20
        RemoveDuplicatesFromSortedLLNode head = new RemoveDuplicatesFromSortedLLNode(11);
        head.next = new RemoveDuplicatesFromSortedLLNode(11);
        head.next.next = new RemoveDuplicatesFromSortedLLNode(11);
        head.next.next.next = new RemoveDuplicatesFromSortedLLNode(13);
        head.next.next.next.next = new RemoveDuplicatesFromSortedLLNode(13);
        head.next.next.next.next.next = new RemoveDuplicatesFromSortedLLNode(20);

        System.out.println(
                "Linked list before duplicate removal:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println(
                "Linked list after duplicate removal:");
        printList(head);
    }
}

