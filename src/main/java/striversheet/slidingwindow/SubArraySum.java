package striversheet.slidingwindow;

import java.util.*;
class SubArraySum {
    // Function to count number of subarrays with sum equal to goal
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Variable to store the final count of valid subarrays
        int count = 0;

        // Outer loop to fix the starting index of subarray
        for (int start = 0; start < nums.length; start++) {
            // Variable to store sum of current subarray
            int sum = 0;

            // Inner loop to fix the ending index of subarray
            for (int end = start; end < nums.length; end++) {
                // Add the current element to sum
                sum += nums[end];

                // If subarray sum equals goal, increment count
                if (sum == goal) {
                    count++;
                }
            }
        }

        // Return the total count of valid subarrays
        return count;
    }
}

// Driver code
class SubArraySumMain {
    public static void main(String[] args) {
        SubArraySum obj = new SubArraySum();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        // Output : 4
        System.out.println(obj.numSubarraysWithSum(nums, goal));
    }
}
