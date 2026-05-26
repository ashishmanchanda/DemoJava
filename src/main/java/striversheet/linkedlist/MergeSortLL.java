package striversheet.linkedlist;

class MergeSortLLNode {
    int data;
    MergeSortLLNode next;
    MergeSortLLNode(int x) {
        data = x;
        next = null;
    }
}

// Function to split the singly linked list into two halves
class MergeSortGfG {
    static MergeSortLLNode split(MergeSortLLNode head) {
        MergeSortLLNode fast = head;
        MergeSortLLNode slow = head;

        // Move fast pointer two steps and slow pointer
        // one step until fast reaches the end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        // Split the list into two halves
        MergeSortLLNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    // Function to merge two sorted singly linked lists
    static MergeSortLLNode merge(MergeSortLLNode first, MergeSortLLNode second) {

        // If either list is empty, return the other list
        if (first == null) return second;
        if (second == null) return first;

        // Pick the smaller value between first and second MergeSortLLNodes
        if (first.data < second.data) {

            // Recursively merge the rest of the lists and
            // link the result to the current MergeSortLLNode
            first.next = merge(first.next, second);
            return first;
        }
        else {
            // Recursively merge the rest of the lists
            // and link the result to the current MergeSortLLNode
            second.next = merge(first, second.next);
            return second;
        }
    }

    // Function to perform merge sort on a singly linked list
    static MergeSortLLNode mergeSort(MergeSortLLNode head) {

        // Base case: if the list is empty or has only one MergeSortLLNode, 
        // it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        MergeSortLLNode second = split(head);

        // Recursively sort each half
        head = mergeSort(head);
        second = mergeSort(second);

        // Merge the two sorted halves
        return merge(head, second);
    }

    static void printList(MergeSortLLNode head) {
        MergeSortLLNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            if(curr.next != null){
                System.out.print("-> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a hard-coded singly linked list:
        // 9 -> 8 -> 5 -> 2
        MergeSortLLNode head = new MergeSortLLNode(9);
        head.next = new MergeSortLLNode(8);
        head.next.next = new MergeSortLLNode(5);
        head.next.next.next = new MergeSortLLNode(2);

        head = mergeSort(head);
        printList(head);
    }
}
