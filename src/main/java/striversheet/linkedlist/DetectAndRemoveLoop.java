package striversheet.linkedlist;

// Java program Using Floyd's Cycle Detection Algorithm 
class DetectAndRemoveLoopNOde {

    int data;
    DetectAndRemoveLoopNOde next;

    DetectAndRemoveLoopNOde(int x) {
        data = x;
        next = null;
    }
}

class DetectGfG {

    // Function that detects loop in the list
    static void removeLoop(DetectAndRemoveLoopNOde head) {

        // If list is empty or has only one DetectAndRemoveLoopNOde
        // without loop
        if (head == null || head.next == null)
            return;

        DetectAndRemoveLoopNOde slow = head, fast = head;

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
            slow = head;
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

    static void printList(DetectAndRemoveLoopNOde curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 3 -> 4
        DetectAndRemoveLoopNOde head = new DetectAndRemoveLoopNOde(1);
        head.next = new DetectAndRemoveLoopNOde(3);
        head.next.next = new DetectAndRemoveLoopNOde(4);

        // Create a loop
        head.next.next.next = head.next;

        removeLoop(head);
        printList(head);
    }
}

