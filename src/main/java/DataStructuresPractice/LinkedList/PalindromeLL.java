package DataStructuresPractice.LinkedList;

// Java program to check if linked list is palindrome
class PalindromLLNode {
    int data;
    PalindromLLNode next;
    PalindromLLNode(int d) {
        data = d;
        next = null;
    }
}

// Class to check if the linked list is palindrome or not
class PalindromLL {

    // Function to reverse a linked list
    static PalindromLLNode reverseList(PalindromLLNode head) {
        PalindromLLNode prev = null;
        PalindromLLNode curr = head;
        PalindromLLNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to check if two lists are identical
    static boolean isIdentical(PalindromLLNode n1, PalindromLLNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    // Function to check whether the list is palindrome
    static boolean isPalindrome(PalindromLLNode head) {
        if (head == null || head.next == null)
            return true;

        PalindromLLNode slow = head, fast = head;

        while (fast.next != null
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        PalindromLLNode head2 = reverseList(slow.next);
        slow.next = null;

        boolean ret = isIdentical(head, head2);

        head2 = reverseList(head2);
        slow.next = head2;

        return ret;
    }

    public static void main(String[] args) {

        // Linked list : 1->2->3->2->1
        PalindromLLNode head = new PalindromLLNode(1);
        head.next = new PalindromLLNode(2);
        head.next.next = new PalindromLLNode(3);
        head.next.next.next = new PalindromLLNode(2);
        head.next.next.next.next = new PalindromLLNode(1);

        boolean result = isPalindrome(head);

        if (result)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

