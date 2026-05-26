package striversheet.linkedlist;

import java.util.HashSet;

class RemoveDuplicatesUnsortedNode {
    int data;
    RemoveDuplicatesUnsortedNode next;
    RemoveDuplicatesUnsortedNode(int x) {
        data = x;
        next = null;
    }
}

class RemoveDuplicatesUnsortedNodeGfG {
    static RemoveDuplicatesUnsortedNode removeDuplicates(RemoveDuplicatesUnsortedNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        RemoveDuplicatesUnsortedNode curr = head;
        RemoveDuplicatesUnsortedNode prev = null;

        while (curr != null) {

            // Check if the element is already in the hash table
            if (hashSet.contains(curr.data)) {

                // Element is present, remove it
                prev.next = curr.next;
            } else {

                // Element is not present, add it to hash table
                hashSet.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    static void printList(RemoveDuplicatesUnsortedNode head) {
        RemoveDuplicatesUnsortedNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a singly linked list:
        // 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
        RemoveDuplicatesUnsortedNode head = new RemoveDuplicatesUnsortedNode(12);
        head.next = new RemoveDuplicatesUnsortedNode(11);
        head.next.next = new RemoveDuplicatesUnsortedNode(12);
        head.next.next.next = new RemoveDuplicatesUnsortedNode(21);
        head.next.next.next.next = new RemoveDuplicatesUnsortedNode(41);
        head.next.next.next.next.next = new RemoveDuplicatesUnsortedNode(43);
        head.next.next.next.next.next.next = new RemoveDuplicatesUnsortedNode(21);

        head = removeDuplicates(head);
        printList(head);
    }
}
