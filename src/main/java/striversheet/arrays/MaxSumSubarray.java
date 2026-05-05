package striversheet.arrays;

import java.util.*;

// Class containing the sliding window algorithm
class MaxSumSubarray {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        // To store the maximum length of the subarray
        int maxLen = 0;

        // Pointers for sliding window
        int left = 0, right = 0;

        // Sum of the current window
        int sum = nums[0];

        // Traverse through the array
        while (right < n) {

            // Shrink the window if sum exceeds k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // Update max length if sum equals k
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Expand the window to the right
            right++;
            if (right < n) {
                sum += nums[right];
            }
        }

        return maxLen;
    }
}

// Separate class containing only the main method
 class MaxSumSubarrayMain {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        // Create Solution object
        MaxSumSubarray sol = new MaxSumSubarray();

        // Function call to find the result
        int ans = sol.longestSubarray(nums, k);

        // Output the result
        System.out.println("The length of longest subarray having sum k is: " + ans);
    }
}

