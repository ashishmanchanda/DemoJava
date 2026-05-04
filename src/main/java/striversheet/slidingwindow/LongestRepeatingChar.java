package striversheet.slidingwindow;

import java.util.*;

class Solution {
    // Function to return the length of the longest substring that can be made of repeating characters
    // by replacing at most k characters
    public int characterReplacement(String s, int k) {

        // Array to count frequency of characters in window
        int[] freq = new int[26];

        // Left pointer of sliding window
        int left = 0;

        // Tracks the highest frequency in the window
        int maxFreq = 0;

        // Stores result
        int maxLen = 0;

        // Traverse the string with right pointer
        for (int right = 0; right < s.length(); right++) {

            // Increment count of current character
            freq[s.charAt(right) - 'A']++;

            // Update max frequency in current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If number of changes exceeds k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update result with valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "AABABBA";
        int k = 1;
        System.out.println(sol.characterReplacement(s, k));
    }
}
