package DataStructuresPractice.LinkedList;

// Java program to find Nth node from
// end of linked list

// Link list node
class KthNodeFromLast {
    int data;
    KthNodeFromLast next;

    // Constructor to initialize a new node with data
    KthNodeFromLast(int new_data) {
        data = new_data;
        next = null;
    }
}

public class KthFromLast {
    // Function to find the Nth node from the last of a linked list
    static int findNthFromLast(KthNodeFromLast head, int N) {
        int len = 0, i;

        // Pointer to store the copy of head
        KthNodeFromLast temp = head;

        // Count the number of nodes in Linked List
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // Check if value of N is not more than length of the linked list
        if (len < N)
            return -1;

        temp = head;

        // Get the (len - N + 1)th node from the beginning
        for (i = 1; i < len - N + 1; i++)
            temp = temp.next;

        return temp.data;
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 35 -> 15 -> 4 -> 20
        KthNodeFromLast head = new KthNodeFromLast(35);
        head.next = new KthNodeFromLast(15);
        head.next.next = new KthNodeFromLast(4);
        head.next.next.next = new KthNodeFromLast(20);

        // Function Call to find the 4th node from end
        System.out.println(findNthFromLast(head, 4));
    }
}

