package striversheet.stackandqueues;

class SubArrayMinBruteForce {

    // Function to find the sum of the minimum value in each subarray
    public int sumSubarrayMins(int[] arr) {
        // Size of the array
        int n = arr.length;

        // Modulo value to prevent integer overflow
        int mod = (int)1e9 + 7;

        // Variable to store the total sum
        int sum = 0;

        // Traverse each starting index of subarrays
        for (int i = 0; i < n; i++) {
            // Initialize the minimum as the current element
            int mini = arr[i];

            // Traverse all subarrays starting at index i
            for (int j = i; j < n; j++) {
                // Update the minimum in the current subarray
                mini = Math.min(mini, arr[j]);

                // Add the current minimum to the total sum
                sum = (sum + mini) % mod;
            }
        }

        // Return the total computed sum
        return sum;
    }
}

// Separate class containing the main method
 class SubArrayMinBruteForceMain {
    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 5};

        // Create instance of Solution
        SubArrayMinBruteForce sol = new SubArrayMinBruteForce();

        // Call the function to get the sum of minimums
        int ans = sol.sumSubarrayMins(arr);

        // Print the result
        System.out.println("The sum of minimum value in each subarray is: " + ans);
    }
}
