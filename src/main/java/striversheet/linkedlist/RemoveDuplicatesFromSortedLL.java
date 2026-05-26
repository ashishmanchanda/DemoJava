package striversheet.linkedlist;

import java.io.*;

class RemoveDuplicatesNode {
    int data;
    RemoveDuplicatesNode next;
    RemoveDuplicatesNode(int x)
    {
        data = x;
        next = null;
    }
}

class RemoveDuplicatesNodeGfG {

    // Function to remove duplicates
    static RemoveDuplicatesNode removeDuplicates(RemoveDuplicatesNode head)
    {
        RemoveDuplicatesNode curr = head;

        // Traverse the list
        while (curr != null && curr.next != null) {

            // Check if next value is the same as curr
            if (curr.data == curr.next.data) {
                RemoveDuplicatesNode nextNext = curr.next.next;
                curr.next = nextNext;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }

    // Driver code
    public static void main(String[] args)
    {

        // Create a sorted linked list:
        // 11->11->11->13->13->20
        RemoveDuplicatesNode head = new RemoveDuplicatesNode(11);
        head.next = new RemoveDuplicatesNode(11);
        head.next.next = new RemoveDuplicatesNode(11);
        head.next.next.next = new RemoveDuplicatesNode(13);
        head.next.next.next.next = new RemoveDuplicatesNode(13);
        head.next.next.next.next.next = new RemoveDuplicatesNode(20);


        RemoveDuplicatesNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        head = removeDuplicates(head);

        // listwith no duplicate
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
