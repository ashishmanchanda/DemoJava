package striversheet.arrays;

import java.util.*;

class ArrayManipulator {

    // Function to rearrange elements by alternating sign
    public int[] rearrangeBySign(int[] A) {
        int n = A.length;

        // Result array initialized to size n
        int[] ans = new int[n];

        // posIndex for even indices (positive), negIndex for odd (negative)
        int posIndex = 0, negIndex = 1;

        // Traverse input array
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                // Place negative number at odd index
                ans[negIndex] = A[i];
                negIndex += 2;
            } else {
                // Place positive number at even index
                ans[posIndex] = A[i];
                posIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5};

        ArrayManipulator obj = new ArrayManipulator();
        int[] result = obj.rearrangeBySign(A);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

