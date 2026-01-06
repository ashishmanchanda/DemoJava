package DataStructuresPractice.LinkedList;

// Java program to rotate a Doubly linked
// list counter clock wise by N times

/* Link list node */
class RotateLLByNNode {
    char data;
    RotateLLByNNode prev;
    RotateLLByNNode next;
    RotateLLByNNode(char d)
    {
        data = d;
        prev = next = null;
    }
}

class RotateLLByN {

    // This function rotates a doubly linked
    // list counter-clockwise and updates the
    // head. The function assumes that N is
    // smallerthan size of linked list. It
    // doesn't modify the list if N is greater
    // than or equal to size
    static RotateLLByNNode rotate(RotateLLByNNode head, int N)
    {
        if (N == 0)
            return head;

        // Let us understand the below code
        // for example N = 2 and
        // list = a <-> b <-> c <-> d <-> e.
        RotateLLByNNode current = head;

        // current will either point to Nth
        // or NULL after this loop. Current
        // will point to node 'b' in the
        // above example
        int count = 1;
        while (count < N && current != null) {
            current = current.next;
            count++;
        }

        // If current is NULL, N is greater
        // than or equal to count of nodes
        // in linked list. Don't change the
        // list in this case
        if (current == null)
            return head;

        // current points to Nth node. Store
        // it in a variable. NthNode points to
        // node 'b' in the above example
        RotateLLByNNode NthNode = current;

        // current will point to last node
        // after this loop current will point
        // to node 'e' in the above example
        while (current.next != null)
            current = current.next;

        // Change next of last node to previous
        // head. Next of 'e' is now changed to
        // node 'a'
        current.next = head;

        // Change prev of Head node to current
        // Prev of 'a' is now changed to node 'e'
        (head).prev = current;

        // Change head to (N+1)th node
        // head is now changed to node 'c'
        head = NthNode.next;

        // Change prev of New Head node to NULL
        // Because Prev of Head Node in Doubly
        // linked list is NULL
        (head).prev = null;

        // change next of Nth node to NULL
        // next of 'b' is now NULL
        NthNode.next = null;

        return head;
    }

    /* Function to print linked list */
    static void printList(RotateLLByNNode node)
    {
        while (node != null && node.next != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        if (node != null)
            System.out.print(node.data);
    }

    // Driver's Code
    public static void main(String[] args)
    {
        /* Start with the empty list */
        RotateLLByNNode head = null;

        /* Let us create the doubly
        linked list a<->b<->c<->d<->e */

        head = new RotateLLByNNode('a');
        head.next = new RotateLLByNNode('b');
        head.next.next = new RotateLLByNNode('c');
        head.next.next.next = new RotateLLByNNode('d');
        head.next.next.next.next = new RotateLLByNNode('e');;

        int N = 2;

        System.out.println("Given linked list ");
        printList(head);
        head = rotate(head, N);
        System.out.println();
        System.out.println("Rotated Linked list ");
        printList(head);
    }
}

