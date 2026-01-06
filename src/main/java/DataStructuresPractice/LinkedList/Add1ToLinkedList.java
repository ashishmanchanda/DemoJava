package DataStructuresPractice.LinkedList;

// Java program to add 1 to a linked list

class Add1ToLinkedListNode {
    int data;
    Add1ToLinkedListNode next;

    Add1ToLinkedListNode(int x) {
        this.data = x;
        this.next = null;
    }
}

// Function to reverse the linked list
class Add1ToLinkedList {
    static Add1ToLinkedListNode reverse(Add1ToLinkedListNode head) {
        Add1ToLinkedListNode curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add one to a linked list and
    // return the head node of the resultant list
    static Add1ToLinkedListNode addOneUtil(Add1ToLinkedListNode head) {
        Add1ToLinkedListNode res = head;
        Add1ToLinkedListNode curr = head;
        Add1ToLinkedListNode last = null;

        // Initialize carry with 1 (to add one)
        int carry = 1;
        int sum;

        while (curr != null) {

            // Calculate sum of carry
            // and current node's data
            sum = carry + curr.data;

            // Update carry for next digit
            carry = (sum >= 10) ? 1 : 0;

            // Update current node's data to sum modulo 10
            curr.data = sum % 10;

            // Move to the next node
            last = curr;
            curr = curr.next;
        }

        // If there's a carry left, add a new
        // node with carry value
        if (carry > 0) {
            last.next = new Add1ToLinkedListNode(carry);
        }

        return res;
    }

    // Main function to add one to the linked list
    static Add1ToLinkedListNode addOne(Add1ToLinkedListNode head) {

        // Reverse the linked list
        head = reverse(head);

        // Add one to the reversed list
        head = addOneUtil(head);

        // Reverse the list again to restore
        //the original order
        return reverse(head);
    }

    static void printList(Add1ToLinkedListNode head) {
        Add1ToLinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 9 -> 9 -> 9
        Add1ToLinkedListNode head = new Add1ToLinkedListNode(1);
        head.next = new Add1ToLinkedListNode(9);
        head.next.next = new Add1ToLinkedListNode(9);
        head.next.next.next = new Add1ToLinkedListNode(9);

        head = addOne(head);

        printList(head);
    }
}

