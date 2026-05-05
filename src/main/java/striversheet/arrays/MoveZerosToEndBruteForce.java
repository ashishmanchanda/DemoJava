package striversheet.arrays;

import java.util.*;

// Solution class
class MoveZerosToEndBruteForce {
    // Function to move all zeroes to end
    public int[] moveZeroes(int[] arr) {
        // Create temp array
        int[] temp = new int[arr.length];

        // Pointer for temp
        int index = 0;

        // Traverse input array
        for (int i = 0; i < arr.length; i++) {
            // If non-zero, copy to temp
            if (arr[i] != 0) {
                temp[index] = arr[i];
                index++;
            }
        }

        // Copy temp back to original
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        // Return updated array
        return arr;
    }
}

// Main class
 class MoveZerosToEndBruteForceMain {
    public static void main(String[] args) {
        // Input array
        int[] arr = {0, 1, 0, 3, 12};

        // Solution object
        MoveZerosToEndBruteForce sol = new MoveZerosToEndBruteForce();

        // Call the function
        int[] result = sol.moveZeroes(arr);

        // Print the result
        System.out.print("Array after moving zeroes: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

