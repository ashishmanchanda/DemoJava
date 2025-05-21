package DataStructuresPractice.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxOfSubArrayOfSizeK {
    public static List<Integer> maxSlidingWindow(int[] arr,
                                                 int k)
    {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(
                (a, b) -> b.value - a.value);

        // Initialize the heap with the first k elements
        for (int i = 0; i < k; i++) {
            heap.offer(new Pair(arr[i], i));
        }

        // The maximum element in the first window
        ans.add(heap.peek().value);

        // Process the remaining elements
        for (int i = k; i < arr.length; i++) {
            heap.offer(new Pair(arr[i], i));

            // Remove elements that are outside the current
            // window
            while (heap.peek().index <= i - k) {
                heap.poll();
            }

            // The maximum element in the current window
            ans.add(heap.peek().value);
        }

        return ans;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 7, 9, 5, 1, 6, 4, 3 };
        int k = 3;

        // Find the maximum element in each sliding window
        // of size k
        List<Integer> result = maxSlidingWindow(arr, k);

        // Print the results
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}