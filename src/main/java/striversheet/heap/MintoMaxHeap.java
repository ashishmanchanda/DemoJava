package striversheet.heap;
import java.util.*;

class GFG {

    // to heapify a subtree with root at given index
    static void maxHeapify(int[] arr, int i)
    {
        int n = arr.length;

        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < n && arr[l] > arr[i])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest!= i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, largest);
        }
    }

    // This function basically builds max heap
    static void convertMaxHeap(int[] arr)
    {
        int n = arr.length;

        // Start from bottommost and rightmost
        // internal node and heapify all internal
        // nodes in bottom up way
        for (int i = (n - 2) / 2; i >= 0; --i)
            maxHeapify(arr, i);
    }

    // Driver's code
    public static void main(String[] args)
    {
        // array representing Min Heap
        int[] arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};

        convertMaxHeap(arr);

        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}

// Contributed by Pramod Kumar