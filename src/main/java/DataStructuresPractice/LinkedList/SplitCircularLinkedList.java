package DataStructuresPractice.LinkedList;

// Java Program to split a circular
// linked list into two halves

class SplitCircularLinkedListNode {
    int data;
    SplitCircularLinkedListNode next;

    SplitCircularLinkedListNode(int newValue) {
        data = newValue;
        next = null;
    }
}

class Pair {
    SplitCircularLinkedListNode first;
    SplitCircularLinkedListNode second;

    Pair(SplitCircularLinkedListNode first, SplitCircularLinkedListNode second) {
        this.first = first;
        this.second = second;
    }
}

public class SplitCircularLinkedList {

    // Function to split a list into two lists.
    static Pair splitList(SplitCircularLinkedListNode head) {
        SplitCircularLinkedListNode slow = head;
        SplitCircularLinkedListNode fast = head;

        if (head == null) {
            return new Pair(null, null);
        }

        // For odd nodes, fast.next is head and
        // for even nodes, fast.next.next is head
        while (fast.next != head &&
                fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // If there are even elements in
        // the list then move fast
        if (fast.next.next == head) {
            fast = fast.next;
        }

        // Set the head pointer of the first half
        SplitCircularLinkedListNode head1 = head;

        // Set the head pointer of the second half
        SplitCircularLinkedListNode head2 = slow.next;

        // Make the second half circular
        fast.next = slow.next;

        // Make the first half circular
        slow.next = head;

        return new Pair(head1, head2);
    }

    static void printList(SplitCircularLinkedListNode head) {
        SplitCircularLinkedListNode curr = head;
        if (head != null) {
            do {
                System.out.print(curr.data + " ");
                curr = curr.next;
            } while (curr != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        SplitCircularLinkedListNode head1 = null;
        SplitCircularLinkedListNode head2 = null;

        // Created linked list will be 1->2->3->4
        SplitCircularLinkedListNode head = new SplitCircularLinkedListNode(1);
        head.next = new SplitCircularLinkedListNode(2);
        head.next.next = new SplitCircularLinkedListNode(3);
        head.next.next.next = new SplitCircularLinkedListNode(4);
        head.next.next.next.next = head;

        Pair result = splitList(head);
        head1 = result.first;
        head2 = result.second;

        printList(head1);
        printList(head2);
    }
}

