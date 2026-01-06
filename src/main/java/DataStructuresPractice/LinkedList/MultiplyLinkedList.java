package DataStructuresPractice.LinkedList;

// Java program to Multiply two numbers
// represented as linked lists

class MultiplyLinkedListNode {
    int data;
    MultiplyLinkedListNode next;

    MultiplyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MultiplyLinkedList {

    // Multiply contents of two linked lists
    static long multiplyTwoLists(MultiplyLinkedListNode first, MultiplyLinkedListNode second) {
        long MOD = 1000000007;
        long num1 = 0, num2 = 0;

        // Traverse the first list and
        // construct the number with modulo
        while (first != null || second != null) {
            if (first != null) {
                num1 = ((num1 * 10) + first.data) % MOD;
                first = first.next;
            }

            // Traverse the second list and
            // construct the number with modulo
            if (second != null) {
                num2 = ((num2 * 10) + second.data) % MOD;
                second = second.next;
            }
        }

        // Return the product of the two
        // numbers with modulo
        return (num1 * num2) % MOD;
    }
    static void printList(MultiplyLinkedListNode curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String args[]) {

        // create first list 9->4->6
        MultiplyLinkedListNode head1 = new MultiplyLinkedListNode(9);
        head1.next = new MultiplyLinkedListNode(4);
        head1.next.next = new MultiplyLinkedListNode(6);

        // create second list 8->4
        MultiplyLinkedListNode head2 = new MultiplyLinkedListNode(8);
        head2.next = new MultiplyLinkedListNode(4);
        System.out.println(multiplyTwoLists(head1, head2));
    }
}

