package DataStructuresPractice.LinkedList;

// Java program to return first node of loop.
class FindStartingPointNode {
    int data;
    FindStartingPointNode next;

    FindStartingPointNode(int x) {
        data = x;
        next = null;
    }
}

class FindStartingPoint {

    // Function to detect a loop in the linked list and
    // return the node where the cycle starts
    // using Floyd’s Cycle-Finding Algorithm
    static FindStartingPointNode detectLoop(FindStartingPointNode head) {

        // Initialize two pointers, slow and fast
        FindStartingPointNode slow = head;
        FindStartingPointNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {

            // Move slow pointer by one step
            slow = slow.next;

            // Move fast pointer by two steps
            fast = fast.next.next;

            // Detect loop
            if (slow == fast) {

                // Move slow to head, keep fast at meeting point
                slow = head;

                // Move both one step at a time until they meet
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the meeting node, which is the
                // start of the loop
                return slow;
            }
        }

        // No loop found
        return null;
    }

    public static void main(String[] args) {

        // Create a linked list: 10 -> 15 -> 4 -> 20
        FindStartingPointNode head = new FindStartingPointNode(10);
        head.next = new FindStartingPointNode(15);
        head.next.next = new FindStartingPointNode(4);
        head.next.next.next = new FindStartingPointNode(20);

        head.next.next.next.next = head;

        FindStartingPointNode loopNode = detectLoop(head);

        if (loopNode != null)
            System.out.println(loopNode.data);
        else
            System.out.println(-1);
    }
}
