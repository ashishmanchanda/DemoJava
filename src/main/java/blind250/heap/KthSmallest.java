package blind250.heap;

//Driver Code Starts
import java.util.PriorityQueue;
import java.util.Collections;

//Driver Code Ends
class GFG {

    static int kthSmallest(int[] arr, int k)
    {
        // Create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through the array elements
        for (int val : arr)
        {
            // Push the current element onto the max heap
            pq.add(val);

            // If the size of the max heap exceeds k,
            // remove the largest element
            if (pq.size() > k)
                pq.poll();
        }

        // Return the kth smallest element (top of the max heap)
        return pq.peek();
    }

    //Driver Code Starts
    public static void main(String[] args)
    {
        int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k = 4;

        System.out.println(kthSmallest(arr, k));
    }
}

//Driver Code Ends