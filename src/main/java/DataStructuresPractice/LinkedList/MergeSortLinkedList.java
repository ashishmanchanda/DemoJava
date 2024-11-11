package DataStructuresPractice.LinkedList;

// Java program for merge sort on singly linked list

class MergeSortLinkedListNode {
    int data;
    MergeSortLinkedListNode next;
    MergeSortLinkedListNode(int x) {
        data = x;
        next = null;
    }
}

// Function to split the singly linked list into two halves
class MergeSortLinkedList {
    static MergeSortLinkedListNode split(MergeSortLinkedListNode head) {
        MergeSortLinkedListNode fast = head;
        MergeSortLinkedListNode slow = head;

        // Move fast pointer two steps and slow pointer
        // one step until fast reaches the end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        // Split the list into two halves
        MergeSortLinkedListNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    // Function to merge two sorted singly linked lists
    static MergeSortLinkedListNode merge(MergeSortLinkedListNode first, MergeSortLinkedListNode second) {

        // If either list is empty, return the other list
        if (first == null) return second;
        if (second == null) return first;

        // Pick the smaller value between first and second nodes
        if (first.data < second.data) {

            // Recursively merge the rest of the lists and
            // link the result to the current node
            first.next = merge(first.next, second);
            return first;
        }
        else {
            // Recursively merge the rest of the lists
            // and link the result to the current node
            second.next = merge(first, second.next);
            return second;
        }
    }

    // Function to perform merge sort on a singly linked list
    static MergeSortLinkedListNode mergeSort(MergeSortLinkedListNode head) {

        // Base case: if the list is empty or has only one node,
        // it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        MergeSortLinkedListNode second = split(head);

        // Recursively sort each half
        head = mergeSort(head);
        second = mergeSort(second);

        // Merge the two sorted halves
        return merge(head, second);
    }

    static void printList(MergeSortLinkedListNode head) {
        MergeSortLinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a hard-coded singly linked list:
        // 9 -> 8 -> 5 -> 2
        MergeSortLinkedListNode head = new MergeSortLinkedListNode(9);
        head.next = new MergeSortLinkedListNode(8);
        head.next.next = new MergeSortLinkedListNode(5);
        head.next.next.next = new MergeSortLinkedListNode(2);

        head = mergeSort(head);
        printList(head);
    }
}

