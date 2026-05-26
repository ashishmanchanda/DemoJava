package striversheet.linkedlist;

class IntersectionPointNode {
    int num;
    IntersectionPointNode next;
    IntersectionPointNode(int val) {
        num = val;
        next = null;
    }
}

class IntersectionPointNodeSolution {
    // Utility function to insert IntersectionPointNode at the end of the linked list
    public void insertIntersectionPointNode(IntersectionPointNode head, int val) {
        IntersectionPointNode newIntersectionPointNode = new IntersectionPointNode(val);
        if (head == null) {
            head = newIntersectionPointNode;
            return;
        }
        IntersectionPointNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newIntersectionPointNode;
    }

    // Utility function to check presence of intersection
    public IntersectionPointNode intersectionPresent(IntersectionPointNode head1, IntersectionPointNode head2) {
        IntersectionPointNode d1 = head1;
        IntersectionPointNode d2 = head2;

        // Traverse both lists, when one reaches the end, redirect it to the head of the other list
        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }

        return d1;  // If they meet, return the intersection IntersectionPointNode, otherwise NULL
    }

    // Utility function to print linked list
    public void printList(IntersectionPointNode head) {
        while (head != null && head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        if (head != null) {
            System.out.print(head.num);
        }
        System.out.println();
    }
}

 class IntersectionPointNodeSolutionMain {
    public static void main(String[] args) {
        IntersectionPointNodeSolution sol = new IntersectionPointNodeSolution();

        // Creation of both lists
        IntersectionPointNode head = new IntersectionPointNode(1);
        sol.insertIntersectionPointNode(head, 3);
        sol.insertIntersectionPointNode(head, 1);
        sol.insertIntersectionPointNode(head, 2);
        sol.insertIntersectionPointNode(head, 4);
        IntersectionPointNode head1 = head;
        head = head.next.next.next;  // Intersection point
        IntersectionPointNode headSec = new IntersectionPointNode(3);
        IntersectionPointNode head2 = headSec;
        headSec.next = head;  // Creating intersection

        // Printing the lists
        System.out.print("List1: ");
        sol.printList(head1);
        System.out.print("List2: ");
        sol.printList(head2);

        // Checking if intersection is present
        IntersectionPointNode answerIntersectionPointNode = sol.intersectionPresent(head1, head2);
        if (answerIntersectionPointNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("The intersection point is " + answerIntersectionPointNode.num);
        }
    }
}
