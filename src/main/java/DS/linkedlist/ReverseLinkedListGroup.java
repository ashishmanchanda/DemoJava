package DS.linkedlist;

// Java program to reverse a linked list in groups of 
// given size 
class ReverseLinkedListGroup {
    ReverseNode head; // head of list

    /* Linked list Node*/
    class ReverseNode {
        int data;
        ReverseNode next;
        ReverseNode(int d)
        {
            data = d;
            next = null;
        }
    }

    ReverseNode reverseg(ReverseNode head, int k)
    {
        if(head == null)
            return null;
        ReverseNode current = head;
        ReverseNode next = null;
        ReverseNode prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        } 

		/* next is now a pointer to (k+1)th node 
		Recursively call for the list starting from 
		current. And make rest of the list as next of 
		first node */
        if (next != null)
            head.next = reverseg(next, k);

        // prev is now head of input list 
        return prev;
    }

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    { 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
        ReverseNode new_node = new ReverseNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList()
    {
        ReverseNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        ReverseLinkedListGroup llist = new ReverseLinkedListGroup();

		/* Constructed Linked List is 1->2->3->4->5->6-> 
		7->8->8->9->null */
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverseg(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
}
/* This code is contributed by Rajat Mishra */

