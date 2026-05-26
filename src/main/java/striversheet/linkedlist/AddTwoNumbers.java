package striversheet.linkedlist;

class AddTwoNumbers {
    int data;
    AddTwoNumbers next;

    AddTwoNumbers(int val) {
        data = val;
        next = null;
    }
}

class AddTwoNumbersGfG {

    // Function to reverse the linked list
    static AddTwoNumbers reverse(AddTwoNumbers head) {
        AddTwoNumbers prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static AddTwoNumbers addTwoLists(AddTwoNumbers head1, AddTwoNumbers head2) {

        // Reverse both lists to start
        // from least significant digit
        head1 = reverse(head1);
        head2 = reverse(head2);

        AddTwoNumbers sum = null;
        int carry = 0;

        // Traverse until both lists
        // and carry are processed
        while (head1 != null || head2 != null || carry > 0) {
            int newVal = carry;

            if (head1 != null) {
                newVal += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                newVal += head2.data;
                head2 = head2.next;
            }

            carry = newVal / 10;
            newVal %= 10;

            // Create new AddTwoNumbers and insert
            // at front of result list
            AddTwoNumbers newAddTwoNumbers = new AddTwoNumbers(newVal);
            newAddTwoNumbers.next = sum;
            sum = newAddTwoNumbers;
        }

        // Remove leading zeros if present
        while (sum != null && sum.data == 0) {
            sum = sum.next;
        }

        return (sum == null) ? new AddTwoNumbers(0) : sum;
    }

    static void printList(AddTwoNumbers head) {
        AddTwoNumbers curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        AddTwoNumbers num1 = new AddTwoNumbers(1);
        num1.next = new AddTwoNumbers(2);
        num1.next.next = new AddTwoNumbers(3);

        AddTwoNumbers num2 = new AddTwoNumbers(9);
        num2.next = new AddTwoNumbers(9);
        num2.next.next = new AddTwoNumbers(9);

        AddTwoNumbers sum = addTwoLists(num1, num2);
        printList(sum);
    }
}
