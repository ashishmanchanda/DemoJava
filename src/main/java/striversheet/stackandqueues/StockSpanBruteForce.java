package striversheet.stackandqueues;

import java.util.*;

class StockSpanBruteForce {

    // Function to find the span of stock prices for each day
    public int[] stockSpan(int[] arr, int n) {
        // To store the answer (stock span for each day)
        int[] ans = new int[n];

        // Traverse through the array
        for(int i = 0; i < n; i++) {
            // To store the current span of stocks
            int currSpan = 0;

            // Traverse backwards to find stock span
            for(int j = i; j >= 0; j--) {
                // Update stock span if the current price is less than or equal to current price
                if(arr[j] <= arr[i]) {
                    currSpan++;
                }
                // Else, break the loop when a higher stock price is found
                else {
                    break;
                }
            }

            // Store the current span in the result array
            ans[i] = currSpan;
        }

        // Return the computed stock span for each day
        return ans;
    }

}

 class StockSpanMain {
    public static void main(String[] args) {
        int n = 7; // Number of days
        int[] arr = {120, 100, 60, 80, 90, 110, 115}; // Stock prices for each day

        // Create an instance of Solution class
        StockSpanBruteForce sol = new StockSpanBruteForce();

        // Call the function to find the stock span for each day
        int[] ans = sol.stockSpan(arr, n);

        // Print the span of stock prices
        System.out.print("The span of stock prices is: ");
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}