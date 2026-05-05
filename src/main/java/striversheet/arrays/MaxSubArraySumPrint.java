package striversheet.arrays;

import java.util.*;

class MaxSubArraySumPrint {
    // Function to find maximum sum of subarrays and print the subarray having maximum sum
    public int maxSubArray(int[] nums) {

        // Maximum sum
        long maxi = Long.MIN_VALUE;

        // Current sum of subarray
        long sum = 0;

        // Starting index of current subarray
        int start = 0;

        // Indices of the maximum sum subarray
        int ansStart = -1, ansEnd = -1;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Update starting index if sum is reset
            if (sum == 0) {
                start = i;
            }

            // Add current element to the sum
            sum += nums[i];

            // Update maxi and subarray indices if current sum is greater
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }

        // Printing the subarray
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        // Return the maximum subarray sum found
        return (int) maxi;
    }
}

// Separate Main class
class MaxSubArraySumPrintMain {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        MaxSubArraySumPrint sol = new MaxSubArraySumPrint();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}

