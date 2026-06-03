package striversheet.linkedlist;

class RevserseLLIterativeNode {
    int data;
    RevserseLLIterativeNode next;

    RevserseLLIterativeNode(int x) {
        data = x;
        next = null;
    }
}

class ReverseGfG {

    static RevserseLLIterativeNode reverseKGroup(RevserseLLIterativeNode head, int k) {
        if (head == null) {
            return head;
        }

        RevserseLLIterativeNode curr = head;
        RevserseLLIterativeNode newHead = null;
        RevserseLLIterativeNode tail = null;

        while (curr != null) {
            RevserseLLIterativeNode groupHead = curr;
            RevserseLLIterativeNode prev = null;
            RevserseLLIterativeNode nextRevserseLLIterativeNode = null;
            int count = 0;

            // Reverse the RevserseLLIterativeNodes in the current group
            while (curr != null && count < k) {
                nextRevserseLLIterativeNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextRevserseLLIterativeNode;
                count++;
            }

            // If newHead is null, set it to the
            // last RevserseLLIterativeNode of the first group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect the previous group to the 
            // current reversed group
            if (tail != null) {
                tail.next = prev;
            }

            // Move tail to the end of the
            // reversed group
            tail = groupHead;
        }

        return newHead;
    }

    static void printList(RevserseLLIterativeNode head) {
        RevserseLLIterativeNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        RevserseLLIterativeNode head = new RevserseLLIterativeNode(1);
        head.next = new RevserseLLIterativeNode(2);
        head.next.next = new RevserseLLIterativeNode(3);
        head.next.next.next = new RevserseLLIterativeNode(4);
        head.next.next.next.next = new RevserseLLIterativeNode(5);

        head = reverseKGroup(head, 3);
        printList(head);
    }
}
