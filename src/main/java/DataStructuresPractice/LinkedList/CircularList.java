package DataStructuresPractice.LinkedList;

// Java program to check if linked list is circular

class CircularListNode {
    int data;
    CircularListNode next;

    CircularListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularList {

    // Function to check if the linked list is circular
    static boolean isCircular(CircularListNode head) {
        if (head == null)
            return true;

        CircularListNode slow = head, fast = head.next;

        // Traverse the linked list with two pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        CircularListNode head = new CircularListNode(1);
        head.next = new CircularListNode(2);
        head.next.next = new CircularListNode(3);
        head.next.next.next = new CircularListNode(4);

        // Check if the linked list is circular
        System.out.println(isCircular(head) ? "Yes" : "No");

        // Making the linked list circular
        head.next.next.next.next = head;

        // Check again if the linked list is circular
        System.out.println(isCircular(head) ? "Yes" : "No");
    }
}
