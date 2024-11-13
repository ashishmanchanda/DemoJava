package DataStructuresPractice.LinkedList;

class DeleteElementFromCLLNode {
    int data;
    DeleteElementFromCLLNode next;

    DeleteElementFromCLLNode(int value) {
        data = value;
        next = null;
    }
}

public class DeleteElementFromCLL {
    public static DeleteElementFromCLLNode deleteFirstNode(DeleteElementFromCLLNode last) {
        if (last == null) {
            // If the list is empty
            System.out.println("List is empty");
            return null;
        }

        DeleteElementFromCLLNode head = last.next;

        if (head == last) {
            // If there is only one node in the list
            last = null;
        } else {
            // More than one node in the list
            last.next = head.next;
        }

        return last;
    }

    public static void printList(DeleteElementFromCLLNode last) {
        if (last == null) return;

        DeleteElementFromCLLNode head = last.next;
        while (true) {
            System.out.print(head.data + " ");
            head = head.next;
            if (head == last.next) break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create circular linked list: 2, 3, 4
        DeleteElementFromCLLNode first = new DeleteElementFromCLLNode(2);
        first.next = new DeleteElementFromCLLNode(3);
        first.next.next = new DeleteElementFromCLLNode(4);

        DeleteElementFromCLLNode last = first.next.next;
        last.next = first;

        System.out.print("Original list: ");
        printList(last);

        // Delete the first node
        last = deleteFirstNode(last);

        System.out.print("List after deleting first node: ");
        printList(last);
    }
}
