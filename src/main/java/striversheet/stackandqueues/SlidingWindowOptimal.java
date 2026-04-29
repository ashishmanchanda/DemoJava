package striversheet.stackandqueues;

import java.util.*;
import java.util.stream.Collectors;

public class SlidingWindowOptimal {

    List<Integer> maxSlidingWindow(int[] arr,int k){
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        // Loop through each element
        for (int i = 0; i < arr.length; i++) {
            // Remove indices out of current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller values from the back of deque
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Add to result once the first window is formed
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }
        // Return result list
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowOptimal obj = new SlidingWindowOptimal();

        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;

        List<Integer> ans = obj.maxSlidingWindow(arr, k);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
