package DataStructuresPractice.LinkedList;

// Java implementation to remove duplicates from
// an unsorted singly linked list using hashing

import java.util.HashSet;

class RemoveDuplicateUnsortedLinkedListNode {
    int data;
    RemoveDuplicateUnsortedLinkedListNode next;
    RemoveDuplicateUnsortedLinkedListNode(int x) {
        data = x;
        next = null;
    }
}

class RemoveDuplicateUnsortedLinkedList {
    static RemoveDuplicateUnsortedLinkedListNode removeDuplicates(RemoveDuplicateUnsortedLinkedListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        RemoveDuplicateUnsortedLinkedListNode curr = head;
        RemoveDuplicateUnsortedLinkedListNode prev = null;

        while (curr != null) {

            // Check if the element is already in the hash table
            if (hashSet.contains(curr.data)) {

                // Element is present, remove it
                prev.next = curr.next;
                curr = curr.next;
            } else {

                // Element is not present, add it to hash table
                hashSet.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    static void printList(RemoveDuplicateUnsortedLinkedListNode head) {
        RemoveDuplicateUnsortedLinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a singly linked list:
        // 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
        RemoveDuplicateUnsortedLinkedListNode head = new RemoveDuplicateUnsortedLinkedListNode(12);
        head.next = new RemoveDuplicateUnsortedLinkedListNode(11);
        head.next.next = new RemoveDuplicateUnsortedLinkedListNode(12);
        head.next.next.next = new RemoveDuplicateUnsortedLinkedListNode(21);
        head.next.next.next.next = new RemoveDuplicateUnsortedLinkedListNode(41);
        head.next.next.next.next.next = new RemoveDuplicateUnsortedLinkedListNode(43);
        head.next.next.next.next.next.next = new RemoveDuplicateUnsortedLinkedListNode(21);

        head = removeDuplicates(head);
        printList(head);
    }
}

