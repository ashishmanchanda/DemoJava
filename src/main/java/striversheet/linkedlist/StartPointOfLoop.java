package striversheet.linkedlist;

class StartPointLoopNOde {
    int data;
    StartPointLoopNOde next;

    StartPointLoopNOde(int x) {
        data = x;
        next = null;
    }
}

class StartGfG {

    static int cycleStart(StartPointLoopNOde head) {
        StartPointLoopNOde slow = head;
        StartPointLoopNOde fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            // Move slow pointer by one step
            slow = slow.next;

            // Move fast pointer by two steps
            fast = fast.next.next;

            if (slow == fast) {

                // Move slow to head
                // keep fast at meeting point
                slow = head;

                // Move both one step at a time until they meet
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the meeting StartPointLoopNOde's data,
                // which is the start of the loop
                return slow.data;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        StartPointLoopNOde head = new StartPointLoopNOde(1);
        head.next = new StartPointLoopNOde(2);
        head.next.next = new StartPointLoopNOde(3);
        head.next.next.next = new StartPointLoopNOde(4);
        head.next.next.next.next = new StartPointLoopNOde(5);
        head.next.next.next.next.next = new StartPointLoopNOde(6);

        head.next.next.next.next.next = head.next.next;

        int loopStartPointLoopNOde = cycleStart(head);

        if (loopStartPointLoopNOde != -1)
            System.out.println(loopStartPointLoopNOde);
        else
            System.out.println(-1);
    }
}