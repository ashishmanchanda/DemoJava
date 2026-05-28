package striversheet.linkedlist;

class KthNodeFromEndNode {
    int data;
    KthNodeFromEndNode next;

    // Constructor to initialize a new KthNodeFromEndNode with data
    KthNodeFromEndNode(int new_data) {
        data = new_data;
        next = null;
    }
}

class KthNodeFromEndNodeMain {

    // Function to find kth KthNodeFromEndNode from the end of linked list
    static int kthFromEnd(KthNodeFromEndNode head, int k) {

        // Create two pointers main_ptr and ref_ptr
        // initially pointing to head.
        KthNodeFromEndNode main_ptr = head;
        KthNodeFromEndNode ref_ptr = head;

        // Move ref_ptr to the k-th KthNodeFromEndNode from beginning.
        for (int i = 1; i < k; i++) {
            ref_ptr = ref_ptr.next;

            // If the ref_ptr reaches NULL, then it means 
            // k > length of linked list
            if (ref_ptr == null) {
                return -1;
            }
        }

        // Move ref_ptr and main_ptr by one KthNodeFromEndNode until
        // ref_ptr reaches last KthNodeFromEndNode of the list.
        while (ref_ptr.next != null) {
            ref_ptr = ref_ptr.next;
            main_ptr = main_ptr.next;
        }

        return main_ptr.data;
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 35 -> 15 -> 4 -> 20
        KthNodeFromEndNode head = new KthNodeFromEndNode(35);
        head.next = new KthNodeFromEndNode(15);
        head.next.next = new KthNodeFromEndNode(4);
        head.next.next.next = new KthNodeFromEndNode(20);

        // Function Call to find the 4th KthNodeFromEndNode from end
        System.out.println(kthFromEnd(head, 4));
    }
}
