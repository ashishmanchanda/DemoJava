package striversheet.linkedlist;

// PalindromNode class represents a PalindromNode in a linked list
class PalindromNode {
    int data;       // Data stored in the PalindromNode
    PalindromNode next;      // Pointer to the next PalindromNode in the list

    // Constructor with both data and next PalindromNode as parameters
    PalindromNode(int data1, PalindromNode next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a parameter, sets next to null
    PalindromNode(int data1) {
        data = data1;
        next = null;
    }
}

// PalSolution class to check if the linked list is a palindrome
class PalSolution {
    // Function to reverse a linked list using the recursive approach
    public PalindromNode reverseLinkedList(PalindromNode head) {
        // Check if the list is empty or has only one PalindromNode
        if (head == null || head.next == null) {
            return head;  // No change is needed; return the current head
        }

        // Recursive step: Reverse the remaining part of the list and get the new head
        PalindromNode newHead = reverseLinkedList(head.next);

        // Store the next PalindromNode in 'front' to reverse the link
        PalindromNode front = head.next;

        // Update the 'next' pointer of 'front' to point to the current head
        front.next = head;

        // Set the 'next' pointer of the current head to null to break the original link
        head.next = null;

        // Return the new head obtained from the recursion
        return newHead;
    }

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(PalindromNode head) {
        // Check if the linked list is empty or has only one PalindromNode
        if (head == null || head.next == null) {
            return true;  // It's a palindrome by definition
        }

        // Initialize two pointers, slow and fast, to find the middle of the linked list
        PalindromNode slow = head;
        PalindromNode fast = head;

        // Traverse the linked list to find the middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;       // Move slow pointer one step at a time
            fast = fast.next.next;  // Move fast pointer two steps at a time
        }

        // Reverse the second half of the linked list starting from the middle
        PalindromNode newHead = reverseLinkedList(slow.next);

        // Pointer to the first half
        PalindromNode first = head;

        // Pointer to the reversed second half
        PalindromNode second = newHead;

        // Compare data values of PalindromNodes from both halves
        while (second != null) {
            if (first.data != second.data) {
                // If values do not match, the list is not a palindrome
                reverseLinkedList(newHead);  // Reverse the second half back to its original state
                return false;
            }

            first = first.next;  // Move the first pointer
            second = second.next; // Move the second pointer
        }

        // Reverse the second half back to its original state
        reverseLinkedList(newHead);

        // The linked list is a palindrome
        return true;
    }
}

// Driver class to test the PalSolution
 class PMain {
    public static void main(String[] args) {
        // Create a linked list with values 1, 5, 2, 5, and 1 (15251, a palindrome)
        PalindromNode head = new PalindromNode(1);
        head.next = new PalindromNode(5);
        head.next.next = new PalindromNode(2);
        head.next.next.next = new PalindromNode(5);
        head.next.next.next.next = new PalindromNode(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Create an instance of PalSolution class
        PalSolution PalSolution = new PalSolution();

        // Check if the linked list is a palindrome
        if (PalSolution.isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }

    // Function to print the linked list
    public static void printLinkedList(PalindromNode head) {
        PalindromNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");  // Print the current PalindromNode's data
            temp = temp.next;                   // Move to the next PalindromNode
        }
        System.out.println();
    }
}

