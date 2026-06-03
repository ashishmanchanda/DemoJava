package striversheet.string;

import java.util.*;

// Class containing the main logic for frequency sorting
class FortSolution {

    // Method to sort characters by frequency
    public List<Character> frequencySort(String s) {
        // Array to hold frequency and character for 'a' to 'z'
        Pair[] freq = new Pair[26];

        // Initialize the frequency array
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char)(i + 'a'));
        }

        // Count frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        // Sort array by frequency descending, then by character ascending
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq) return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        // Collect characters with non-zero frequency into result list
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0) result.add(p.ch);
        }

        // Return the final list
        return result;
    }

    // Inner class to store frequency and character
    class Pair {
        int freq;
        char ch;
        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }
}

// Separate class to run the main method
 class FortSolutionMain {
    public static void main(String[] args) {
        // Create instance of Solution
        FortSolution sol = new FortSolution();

        // Input string
        String s = "tree";

        // Get characters sorted by frequency
        List<Character> result = sol.frequencySort(s);

        // Print the result
        System.out.println(result);
    }
}
