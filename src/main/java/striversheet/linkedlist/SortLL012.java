package striversheet.linkedlist;

// SortLLNode class representing each element of the linked list
class SortLLNode {
    int data;
    SortLLNode next;

    // Constructor to initialize SortLLNode with a value
    SortLLNode(int val) {
        data = val;
        next = null;
    }
}

// LinkedList class to manage list operations
class LinkedList {
    SortLLNode head;

    // Constructor to initialize an empty list
    LinkedList() {
        head = null;
    }

    // Function to insert a new SortLLNode at the end
    void insert(int val) {
        SortLLNode newSortLLNode = new SortLLNode(val);
        if (head == null) {
            head = newSortLLNode;
            return;
        }
        SortLLNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newSortLLNode;
    }

    // Function to print the entire linked list
    void print() {
        SortLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }
}

// Solution class containing logic for sorting the list
class SortLLSolution {
    // Function to sort linked list of 0s, 1s, and 2s by rearranging the links
    void sortZeroOneTwo(LinkedList ll) {
        // Create dummy SortLLNodes for 0s, 1s, and 2s
        SortLLNode zeroDummy = new SortLLNode(-1);
        SortLLNode oneDummy = new SortLLNode(-1);
        SortLLNode twoDummy = new SortLLNode(-1);

        // Create tail pointers to add new SortLLNodes in respective lists
        SortLLNode zeroTail = zeroDummy;
        SortLLNode oneTail = oneDummy;
        SortLLNode twoTail = twoDummy;

        SortLLNode curr = ll.head;

        // Traverse the original list
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        // Connect 0s list to 1s, and 1s to 2s
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        // Update original list head
        ll.head = zeroDummy.next;
    }
}

// Main class to run the code
 class SortLLSolutionMain {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        SortLLSolution sol = new SortLLSolution();

        // Inserting SortLLNodes into linked list
        ll.insert(1);
        ll.insert(2);
        ll.insert(0);
        ll.insert(1);
        ll.insert(2);
        ll.insert(0);

        System.out.println("Original List:");
        ll.print();

        // Sorting the list
        sol.sortZeroOneTwo(ll);

        System.out.println("Sorted List:");
        ll.print();
    }
}
