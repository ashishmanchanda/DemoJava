package DataStructuresPractice.LinkedList;

// Java program Using Floyd's Cycle Detection Algorithm
class DetectAndRemoveLoopNode {

    int data;
    DetectAndRemoveLoopNode next;

    DetectAndRemoveLoopNode(int x) {
        data = x;
        next = null;
    }
}

class DetectAndRemoveLoop {

    // Function that detects loop in the list
    static void detectAndRemoveLoop(DetectAndRemoveLoopNode node) {

        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        DetectAndRemoveLoopNode slow = node, fast = node;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        // If loop exists
        if (slow == fast) {
            slow = node;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // since fast->next is the looping point
                // remove loop
                fast.next = null;
            }
            // This case is added if fast and slow
            // pointer meet at first position.
            else {
                while(fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }

    static void printList(DetectAndRemoveLoopNode curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        DetectAndRemoveLoopNode head = new DetectAndRemoveLoopNode(50);
        head.next = new DetectAndRemoveLoopNode(20);
        head.next.next = new DetectAndRemoveLoopNode(15);
        head.next.next.next = new DetectAndRemoveLoopNode(4);
        head.next.next.next.next = new DetectAndRemoveLoopNode(10);

        head.next.next.next.next.next = head.next.next;
        detectAndRemoveLoop(head);
        printList(head);
    }
}

