package DataStructuresPractice.LinkedList;

// Java code to reverse a doubly linked
// list in groups of K size

class RefactorKGroupNode {
    int data;
    RefactorKGroupNode next;
    RefactorKGroupNode prev;

    RefactorKGroupNode(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

// Helper function to reverse K nodes iteratively
class ReverseKGroup {
    public static RefactorKGroupNode reverseKGroup(RefactorKGroupNode head, int k) {
        if (head == null) {
            return head;
        }

        RefactorKGroupNode curr = head;
        RefactorKGroupNode newHead = null;
        RefactorKGroupNode tail = null;

        while (curr != null) {
            RefactorKGroupNode groupHead = curr;
            RefactorKGroupNode prev = null;
            RefactorKGroupNode next = null;
            int count = 0;

            // Reverse the nodes in the current group
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                curr.prev = null;
                if (prev != null) {
                    prev.prev = curr;
                }
                prev = curr;
                curr = next;
                count++;
            }

            // If newHead is null, set it to the
            // last node of the first group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect the previous group to the
            // current reversed group
            if (tail != null) {
                tail.next = prev;
                prev.prev = tail;
            }

            // Move tail to the end of the
            //reversed group
            tail = groupHead;
        }

        return newHead;
    }

    // Function to print the doubly linked list
    public static void printList(RefactorKGroupNode head) {
        RefactorKGroupNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating a sample doubly linked list:
        // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
        RefactorKGroupNode head = new RefactorKGroupNode(1);
        head.next = new RefactorKGroupNode(2);
        head.next.prev = head;
        head.next.next = new RefactorKGroupNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new RefactorKGroupNode(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new RefactorKGroupNode(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new RefactorKGroupNode(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        head = reverseKGroup(head, 2);
        printList(head);
    }
}

