package striversheet.slidingwindow;

import java.util.*;

class CollectFruitsBruteForce {
    // Function to calculate maximum fruits collected
    // with at most two distinct types from any start point
    public int totalFruit(int[] fruits) {

        // Variable to store the maximum fruits collected
        int maxFruits = 0;

        // Loop over each possible starting point
        for (int start = 0; start < fruits.length; ++start) {

            // Map to store the count of fruit types
            Map<Integer, Integer> basket = new HashMap<>();

            // Variable to track current number of fruits collected
            int currentCount = 0;

            // Traverse from current start to the end
            for (int end = start; end < fruits.length; ++end) {

                // Add current fruit to the basket
                basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

                // If basket has more than 2 types, break
                if (basket.size() > 2) {
                    break;
                }

                // Increase current fruit count
                currentCount++;
            }

            // Update the maximum fruits collected
            maxFruits = Math.max(maxFruits, currentCount);
        }

        // Return the result
        return maxFruits;
    }
}

// Driver code
class CollectFruitsBruteForceMain {
    public static void main(String[] args) {
        CollectFruitsBruteForce obj = new CollectFruitsBruteForce();
        int[] fruits = {1, 2, 1};
        System.out.println(obj.totalFruit(fruits)); // Output: 3
    }
}
