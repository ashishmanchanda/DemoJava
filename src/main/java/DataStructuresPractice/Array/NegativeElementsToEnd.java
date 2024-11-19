package DataStructuresPractice.Array;

// Java program to Move All -ve Element At End
// Without changing the relative ordering
// Using Naive Partitioning Algorithm
import java.util.Arrays;

class NegativeElementsToEnd {

    // Function to move all -ve element to end of array
    // in same order.
    static void segregateElements(int[] arr) {
        int n = arr.length;

        // Create an empty array to store result
        int[] temp = new int[n];
        int idx = 0;

        // First fill non-negative elements into the
        // temporary array
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0)
                temp[idx++] = arr[i];
        }

        // Now fill negative elements into the
        // temporary array
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                temp[idx++] = arr[i];
        }

        // copy the elements from temp to arr
        System.arraycopy(temp, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, -3, -2, 7, 5, 11, 6};
        segregateElements(arr);

        for (int ele: arr)
            System.out.print(ele + " ");
    }
}