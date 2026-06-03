package striversheet.string;

// Java program to find the longest common prefix
// using Character by Character Matching

import java.util.*;

class LCPHelper {

    // Function to find the longest common prefix
    // from the set of strings
    static String longestCommonPrefix(String[] arr) {

        // Find length of smallest string
        int minLen = arr[0].length();

        for (String str : arr)
            minLen = Math.min(minLen, str.length());

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < minLen; i++) {

            // Current character (must be the same
            // in all strings to be a part of result)
            char ch = arr[0].charAt(i);

            for (String str : arr) {
                if (str.charAt(i) != ch) {
                    return res.toString();
                }
            }

            // Append to result
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(longestCommonPrefix(arr));
    }
}
