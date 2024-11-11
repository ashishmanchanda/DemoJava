package DataStructuresPractice.LinkedList;

class IntersectionLinkedListNode {
    int data;
    IntersectionLinkedListNode next;

    IntersectionLinkedListNode(int val)
    {
        data = val;
        next = null;
    }
}

class IntersecionLinkedList {
    public static IntersectionLinkedListNode findIntersection(IntersectionLinkedListNode head1,
                                                              IntersectionLinkedListNode head2)
    {
        IntersectionLinkedListNode p1 = head1, p2 = head2;
        IntersectionLinkedListNode head = null, tail = null;

        // Traverse both linked lists and find the common
        // nodes
        while (p1 != null && p2 != null) {
            if (p1.data > p2.data) {
                // Nodes don't match, move to the next node
                // in the list with the smaller value
                p2 = p2.next;
            }
            else if (p2.data > p1.data) {
                // Nodes don't match, move to the next node
                // in the list with the smaller value
                p1 = p1.next;
            }
            else {
                // Nodes match, add the common node to the
                // intersection list
                if (head == null) {
                    head = tail = new IntersectionLinkedListNode(p1.data);
                    // Create a new head for the
                    // intersection list
                }
                else {
                    // Append the new node to the end of the
                    // intersection list
                    tail.next = new IntersectionLinkedListNode(p1.data);
                    tail = tail.next;
                }

                // Move to the next nodes in both lists
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return head;
    }

    public static void main(String[] args)
    {
        // Create the first linked list
        IntersectionLinkedListNode head1 = new IntersectionLinkedListNode(1);
        head1.next = new IntersectionLinkedListNode(2);
        head1.next.next = new IntersectionLinkedListNode(3);
        head1.next.next.next = new IntersectionLinkedListNode(4);
        head1.next.next.next.next = new IntersectionLinkedListNode(6);

        // Create the second linked list
        IntersectionLinkedListNode head2 = new IntersectionLinkedListNode(2);
        head2.next = new IntersectionLinkedListNode(4);
        head2.next.next = new IntersectionLinkedListNode(6);
        head2.next.next.next = new IntersectionLinkedListNode(8);

        // Find the intersection of the two linked lists
        IntersectionLinkedListNode result = findIntersection(head1, head2);

        // Print the intersection list
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }
}

