package algo.backtracking;

class LinkedList {
    int        data;
    LinkedList next;

    LinkedList(int data) {
        this.data = data;
        this.next = null;
    }

}

public class DeleteNodeInLinkedList {

    static LinkedList deleteNode(LinkedList head, int value) {
        LinkedList curr = head;
        LinkedList prev = null;
        while (curr != null) {
            if (curr.data == value) {
                LinkedList tmp = curr.next;
                if (curr.next != null) {
                    curr.data = curr.next.data;
                    curr.next = curr.next.next;
                } else {
                    prev.next = null;
                    curr = null;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next.next = new LinkedList(1);
        LinkedList itr = head;
        System.out.println("input list:");
        while (itr != null) {
            System.out.print(itr.data + " ");
            itr = itr.next;
        }
        deleteNode(head, 2);
        LinkedList itr2 = head;
        System.out.println();
        System.out.println("output list:");
        while (itr2 != null) {
            System.out.print(itr2.data + " ");
            itr2 = itr2.next;
        }
    }
}
