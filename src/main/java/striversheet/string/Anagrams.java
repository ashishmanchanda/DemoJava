package striversheet.string;

// Solution class to check if two strings are anagrams
class Solution {
    // Function to check if two strings are anagrams
    public boolean CheckAnagrams(String str1, String str2) {
        // Case: when both of the strings have different lengths
        if (str1.length() != str2.length())
            return false;

        // Initialize a frequency array to store character counts
        int[] freq = new int[26];

        // Count frequency of each character in str1
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'A']++;  // Increment frequency for each character in str1
        }

        // Decrement frequency for each character in str2
        for (int i = 0; i < str2.length(); i++) {
            freq[str2.charAt(i) - 'A']--;  // Decrement frequency for each character in str2
        }

        // Check if all frequencies are zero, meaning both strings have the same characters
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)  // If any frequency is non-zero, they are not anagrams
                return false;
        }

        return true;  // The strings are anagrams
    }

}
    // Main class to test the Solution class
     class Main {
        public static void main(String[] args) {
            Solution solution = new Solution();  // Create an instance of the Solution class
            String Str1 = "INTEGER";  // Example string to check
            String Str2 = "TEGERNI";  // Example string to check

            // Check if the strings are anagrams and output the result
            if (solution.CheckAnagrams(Str1, Str2))
                System.out.println("True");  // Output "True" if they are anagrams
            else
                System.out.println("False");  // Output "False" if they aren't anagrams
        }
    }


