package striversheet.stackandqueues;

import java.util.*;

class SlidingWindowBruteForce {
    // Function to return max of each sliding window of size k
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // Result list to store maximums
        List<Integer> result = new ArrayList<>();

        // Loop through the array till the window can slide
        for (int i = 0; i <= nums.length - k; i++) {
            // Initialize maxVal with the first element in the window
            int maxVal = nums[i];

            // Traverse the current window
            for (int j = i; j < i + k; j++) {
                // Update maxVal if a bigger number is found
                maxVal = Math.max(maxVal, nums[j]);
            }

            // Add the max value of this window to the result
            result.add(maxVal);
        }

        // Return final result
        return result;
    }
}

// Driver code
class SlidingWindowBruteForceMain {
    public static void main(String[] args) {
        SlidingWindowBruteForce obj = new SlidingWindowBruteForce();

        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;

        List<Integer> ans = obj.maxSlidingWindow(arr, k);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}

