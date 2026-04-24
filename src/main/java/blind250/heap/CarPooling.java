package blind250.heap;

import java.util.Arrays;

/**
 * LeetCode 1094: Car Pooling
 *
 * Problem: Determine if a car with given capacity can pick up and drop off all passengers.
 * The car drives east and cannot turn around.
 *
 * Approach:
 * 1. Create events for each pickup (passenger count +) and dropoff (passenger count -)
 * 2. Sort by location, with pickups before dropoffs at the same location
 * 3. Track current passenger count as we process events
 * 4. If at any point passengers exceed capacity, return false
 *
 * Time Complexity: O(n log n) due to sorting, where n is the number of trips
 * Space Complexity: O(n) for storing events
 */
public class CarPooling {

    /**
     * Checks if all passengers can be picked up and dropped off within car capacity
     * @param trips array where trips[i] = [numPassengers, from, to]
     * @param capacity maximum number of passengers the car can hold
     * @return true if all passengers can be transported, false otherwise
     */
    public boolean carPooling(int[][] trips, int capacity) {
        // Create array of events: [location, type, numPassengers]
        // type: 1 for pickup (before dropoff), -1 for dropoff
        int[][] events = new int[trips.length * 2][2];

        int index = 0;
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            // Pickup event at 'from' location (add passengers)
            events[index][0] = from;
            events[index][1] = numPassengers;
            index++;

            // Dropoff event at 'to' location (remove passengers)
            events[index][0] = to;
            events[index][1] = -numPassengers;
            index++;
        }

        // Sort events by location
        // If same location, process pickups (positive) before dropoffs (negative)
        // This ensures we don't prematurely think we exceed capacity
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];  // Sort by location
            }
            return b[1] - a[1];  // At same location, pickups (positive) come first
        });

        int currentPassengers = 0;

        // Process events in order
        for (int[] event : events) {
            currentPassengers += event[1];

            // If passengers exceed capacity at any point, return false
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }

    // Test cases
    public static void main(String[] args) {
        CarPooling solution = new CarPooling();

        // Test case 1: Should return true
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        System.out.println("Test 1: " + solution.carPooling(trips1, 5));  // Expected: true

        // Test case 2: Should return false
        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        System.out.println("Test 2: " + solution.carPooling(trips2, 3));  // Expected: false

        // Test case 3: Should return true (no overlap)
        int[][] trips3 = {{2, 1, 3}, {3, 4, 6}};
        System.out.println("Test 3: " + solution.carPooling(trips3, 3));  // Expected: true

        // Test case 4: Should return true (single trip)
        int[][] trips4 = {{5, 1, 10}};
        System.out.println("Test 4: " + solution.carPooling(trips4, 5));  // Expected: true

        // Test case 5: Should return false (exceeds capacity)
        int[][] trips5 = {{5, 1, 10}};
        System.out.println("Test 5: " + solution.carPooling(trips5, 4));  // Expected: false
    }
}
