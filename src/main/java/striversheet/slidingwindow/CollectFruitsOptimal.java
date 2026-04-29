package striversheet.slidingwindow;

import java.util.*;

class CollectFruits {
    // Function to find the maximum number of fruits we can collect with at most two fruit types
    public int totalFruit(int[] fruits) {
        // HashMap to track count of each fruit in current window
        Map<Integer, Integer> basket = new HashMap<>();

        // Initialize pointers and max result
        int left = 0;
        int maxFruits = 0;

        // Traverse the fruits array using right pointer
        for (int right = 0; right < fruits.length; right++) {
            // Include current fruit in the map
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If more than 2 fruit types, shrink window from left
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);

                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }

                left++;
            }

            // Update maximum valid window length
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        // Return the final result
        return maxFruits;
    }
}

// Driver code
 class CollectFruitsMain {
    public static void main(String[] args) {
        CollectFruits obj = new CollectFruits();
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println(obj.totalFruit(fruits));
    }
}

