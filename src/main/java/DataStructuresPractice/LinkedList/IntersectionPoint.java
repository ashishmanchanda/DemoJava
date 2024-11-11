package DataStructuresPractice.LinkedList;

// Java program to get intersection point of two linked
// list using hashing

import java.util.HashSet;

class IntersectionPointNode {
    int data;
    IntersectionPointNode next;

    IntersectionPointNode(int new_data) {
        data = new_data;
        next = null;
    }
}

// Function to get the intersection point of two linked
// lists
class IntersectionPoint {
    static IntersectionPointNode getIntersectionNode(IntersectionPointNode head1, IntersectionPointNode head2) {
        HashSet<IntersectionPointNode> visitedNodes = new HashSet<>();

        // Traverse the first list and store all nodes
        // in a set
        IntersectionPointNode curr1 = head1;
        while (curr1 != null) {
            visitedNodes.add(curr1);
            curr1 = curr1.next;
        }

        // Traverse the second list and check if any node is
        // in the set
        IntersectionPointNode curr2 = head2;
        while (curr2 != null) {
            if (visitedNodes.contains(curr2)) {

                // Intersection point found
                return curr2;
            }
            curr2 = curr2.next;
        }

        return null;
    }

    public static void main(String[] args) {

        // Create two linked lists
        // 1st List: 3 -> 6 -> 9 -> 15 -> 30
        // 2nd List: 10 -> 15 -> 30
        // 15 is the intersection point

        // creation of first list
        IntersectionPointNode head1 = new IntersectionPointNode(10);
        head1.next = new IntersectionPointNode(15);
        head1.next.next = new IntersectionPointNode(30);

        // creation of second list
        IntersectionPointNode head2 = new IntersectionPointNode(3);
        head2.next = new IntersectionPointNode(6);
        head2.next.next = new IntersectionPointNode(9);
        head2.next.next.next = head1.next;

        IntersectionPointNode intersectionPoint
                = getIntersectionNode(head1, head2);

        if (intersectionPoint == null)
            System.out.print(" No Intersection Point \n");
        else
            System.out.print("Intersection Point: "
                    + intersectionPoint.data);
    }
}

