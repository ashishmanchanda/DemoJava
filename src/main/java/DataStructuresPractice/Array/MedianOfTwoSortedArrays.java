package DataStructuresPractice.Array;

// Java Program to find the median of two sorted arrays
// of different size using Binary Search

import java.util.Arrays;

class GfG {

    // function to find median of two sorted arrays
    static double medianOf2(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;

        // If arr1 has more elements, then call medianOf2
        // with reversed parameters
        if (n > m) {
            return medianOf2(arr2, arr1);
        }

        int low = 0, high = n;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            // Find elements to the left and right of partition in arr1
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : arr1[mid1]);

            // Find elements to the left and right of partition in arr2
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : arr2[mid2]);

            // If it is a valid partition
            if (l1 <= r2 && l2 <= r1) {

                // If the total elements are even, then median is
                // the average of two middle elements
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                // If the total elements are odd, then median is
                // the middle element
                else {
                    return Math.max(l1, l2);
                }
            }

            // Check if we need to take lesser elements from arr1
            if (l1 > r2) {
                high = mid1 - 1;
            }

            // Check if we need to take more elements from arr1
            else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {-5, 3, 6, 12, 15};
        int[] arr2 = {-12, -10, -6, -3, 4, 10};

        System.out.println(medianOf2(arr1, arr2));
    }
}
