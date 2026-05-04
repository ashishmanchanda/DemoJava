package striversheet.arrays;

import java.util.*;

class RotateKTimes {
    // Function to reverse part of the array between given indices
    void reverseArray(int[] nums, int start, int end) {
        // Swap elements until start meets end
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate array left or right by k steps
    public int[] rotateArray(int[] nums, int k, String direction) {
        // Get array length
        int n = nums.length;

        // Edge case: do nothing if array is empty or k is 0
        if (n == 0 || k == 0) return nums;

        // Normalize k if greater than n
        k = k % n;

        // If rotation is to the right
        if (direction.equals("right")) {
            // Step 1: reverse entire array
            reverseArray(nums, 0, n - 1);

            // Step 2: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 3: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);
        }
        // If rotation is to the left
        else if (direction.equals("left")) {
            // Step 1: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 2: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);

            // Step 3: reverse entire array
            reverseArray(nums, 0, n - 1);
        }

        // Return the rotated array
        return nums;
    }
}

// Driver code
 class RotateKTimesMain {
    public static void main(String[] args) {
        // Create instance of Solution
        RotateKTimes sol = new RotateKTimes();

        // Input array and parameters
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        String direction = "right";

        // Call rotateArray and store result
        int[] result = sol.rotateArray(nums, k, direction);

        // Print rotated array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
