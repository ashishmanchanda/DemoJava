package DataStructuresPractice.LinkedList;

// Java Program to add two numbers represented as
// linked list by creating a new list

class AddTwoListsNode {
    int data;
    AddTwoListsNode next;

    AddTwoListsNode(int val) {
        data = val;
        next = null;
    }
}

public class AddTwoLists {

    // Function to reverse the linked list
    static AddTwoListsNode reverse(AddTwoListsNode head) {
        AddTwoListsNode prev = null;
        AddTwoListsNode curr = head;
        AddTwoListsNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add two numbers represented by linked list
    static AddTwoListsNode addTwoLists(AddTwoListsNode num1, AddTwoListsNode num2) {
        AddTwoListsNode res = null;
        AddTwoListsNode curr = null;
        int carry = 0;

        num1 = reverse(num1);
        num2 = reverse(num2);

        // Iterate till either num1 is not empty or num2 is
        // not empty or carry is greater than 0
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;

            // If num1 linked list is not empty, add it to sum
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            // If num2 linked list is not empty, add it to sum
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            // Create a new node with sum % 10 as its value
            AddTwoListsNode newNode = new AddTwoListsNode(sum % 10);

            // Store the carry for the next nodes
            carry = sum / 10;

            // If this is the first node, then make this node
            // as the head of the resultant linked list
            if (res == null) {
                res = newNode;
                curr = newNode;
            } else {
                // Append new node to resultant linked list
                // and move to the next node
                curr.next = newNode;
                curr = curr.next;
            }
        }

        // Reverse the resultant linked list to get the
        // required linked list
        return reverse(res);
    }

    static void printList(AddTwoListsNode head) {
        AddTwoListsNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating first linked list: 1 -> 2 -> 3
        // (represents 123)
        AddTwoListsNode num1 = new AddTwoListsNode(1);
        num1.next = new AddTwoListsNode(2);
        num1.next.next = new AddTwoListsNode(3);

        // Creating second linked list: 9 -> 9 -> 9
        // (represents 999)
        AddTwoListsNode num2 = new AddTwoListsNode(9);
        num2.next = new AddTwoListsNode(9);
        num2.next.next = new AddTwoListsNode(9);

        AddTwoListsNode sum = addTwoLists(num1, num2);
        printList(sum);
    }
}

