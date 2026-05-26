package striversheet.linkedlist;

// Java program to add 1 to a linked list

class AddOneNode {
    int data;
    AddOneNode next;

    AddOneNode(int x) {
        this.data = x;
        this.next = null;
    }
}

// Function to reverse the linked list
class AddOneGfG {
    static AddOneNode reverse(AddOneNode head) {
        AddOneNode curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add one to a linked list and
    // return the head AddOneNode of the resultant list
    static AddOneNode addOneUtil(AddOneNode head) {
        AddOneNode res = head;
        AddOneNode curr = head;
        AddOneNode last = null;

        // Initialize carry with 1 (to add one)
        int carry = 1;
        int sum;

        while (curr != null) {

            // Calculate sum of carry
            // and current AddOneNode's data
            sum = carry + curr.data;

            // Update carry for next digit
            carry = (sum >= 10) ? 1 : 0;

            // Update current AddOneNode's data to sum modulo 10
            curr.data = sum % 10;

            // Move to the next AddOneNode
            last = curr;
            curr = curr.next;
        }

        // If there's a carry left, add a new
        // AddOneNode with carry value
        if (carry > 0) {
            last.next = new AddOneNode(carry);
        }

        return res;
    }

    // Main function to add one to the linked list
    static AddOneNode addOne(AddOneNode head) {

        // Reverse the linked list
        head = reverse(head);

        // Add one to the reversed list
        head = addOneUtil(head);

        // Reverse the list again to restore
        //the original order
        return reverse(head);
    }

    static void printList(AddOneNode head) {
        AddOneNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 9 -> 9 -> 9
        AddOneNode head = new AddOneNode(1);
        head.next = new AddOneNode(9);
        head.next.next = new AddOneNode(9);
        head.next.next.next = new AddOneNode(9);

        head = addOne(head);

        printList(head);
    }
}
