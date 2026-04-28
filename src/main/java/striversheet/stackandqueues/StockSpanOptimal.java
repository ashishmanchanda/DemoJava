package striversheet.stackandqueues;

import java.util.*;

class Solution {

    /* Function to find the indices of the previous
    greater element for each element in the array */
    private int[] findPGE(int[] arr) {
        int n = arr.length; // Size of the array

        // To store the previous greater elements
        int[] ans = new int[n];

        // Stack to get elements in LIFO fashion
        Stack<Integer> st = new Stack<>();

        // Start traversing from the front
        for (int i = 0; i < n; i++) {
            // Get the current element
            int currEle = arr[i];

            // Pop elements from the stack until we find a greater element
            while (!st.isEmpty() && arr[st.peek()] <= currEle) {
                st.pop();
            }

            // If the stack is empty, it means there's no greater element, so assign -1
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek(); // Otherwise, the top element is the previous greater

            // Push the current index in the stack
            st.push(i);
        }

        // Return the result (indices of previous greater elements)
        return ans;
    }

    // Function to find the span of stock prices for each day
    public int[] stockSpan(int[] arr, int n) {
        // Get the indices of previous greater elements
        int[] PGE = findPGE(arr);

        // To store the final span results
        int[] ans = new int[n];

        // Compute the span for each element using the previous greater element indices
        for (int i = 0; i < n; i++) {
            ans[i] = i - PGE[i]; // Calculate span based on previous greater element
        }

        // Return the result (stock span for each day)
        return ans;
    }

}

 class StockSpanProbMain {
    public static void main(String[] args) {
        int n = 7; // Number of days
        int[] arr = {120, 100, 60, 80, 90, 110, 115}; // Stock prices for each day

        // Create an instance of the Solution class
        Solution sol = new Solution();

        // Call the function to find the stock span for each day
        int[] ans = sol.stockSpan(arr, n);

        // Print the result
        System.out.print("The span of stock prices is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " "); // Display the span of each day
        }
    }
}
