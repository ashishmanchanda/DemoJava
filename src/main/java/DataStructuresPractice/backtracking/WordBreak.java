package DataStructuresPractice.backtracking;
// Java implementation to find valid
// word break using Recursion
import java.util.*;

class GfG {

    // Helper function to perform backtracking
    static void wordBreakHelper(String s, HashSet<String> dictSet,
                                String curr, List<String> res,
                                int start) {

        // If start reaches the end of the string,
        // save the result
        if (start == s.length()) {
            res.add(curr);
            return;
        }

        // Try every possible substring from the current index
        for (int end = start + 1; end <= s.length(); ++end) {
            String word = s.substring(start, end);

            // Check if the word exists in the dictionary
            if (dictSet.contains(word)) {
                String prev = curr;

                // Append the word to the current sentence
                if (!curr.isEmpty()) {
                    curr += " ";
                }
                curr += word;

                // Recurse for the remaining string
                wordBreakHelper(s, dictSet, curr, res, end);

                // Backtrack to restore the current sentence
                curr = prev;
            }
        }
    }

    // Main function to generate all possible sentence breaks
    static List<String> wordBreak(String s, List<String> dict) {

        // Convert dictionary vector to a HashSet
        HashSet<String> dictSet = new HashSet<>(dict);

        List<String> res = new ArrayList<>();
        String curr = "";

        wordBreakHelper(s, dictSet, curr, res, 0);

        return res;
    }

    public static void main(String[] args) {

        String s = "ilikesamsungmobile";
        List<String> dict = Arrays.asList("i", "like", "sam", "sung",
                "samsung", "mobile", "ice",
                "and", "cream", "icecream",
                "man", "go", "mango");

        List<String> result = wordBreak(s, dict);

        for (String sentence : result) {
            System.out.println(sentence);
        }
    }
}
