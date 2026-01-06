package DataStructuresPractice.Array;

import java.util.*;

// Function to find the maximum amount of water that can be trapped
class TrappingRainWater {

    static int findWater(int[] arr) {
        int n = arr.length;

        // Left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int[] left = new int[n];

        // Right[i] contains height of tallest bar to
        // the right of i'th bar including itself
        int[] right = new int[n];

        // Initialize result
        int res = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        for (int i = 1; i < n - 1; i++) {
            int minOf2 = Math.min(left[i - 1], right[i + 1]);
            if (minOf2 > arr[i]) {
                res += minOf2 - arr[i];
            }
        }

        return res;
    }

    // Driver program
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(findWater(arr));
    }
}