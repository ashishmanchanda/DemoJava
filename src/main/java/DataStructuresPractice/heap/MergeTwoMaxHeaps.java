package DataStructuresPractice.heap;

// Java Program to merge two max heaps

import java.util.Arrays;

public class MergeTwoMaxHeaps {

    // Standard heapify function to heapify a subtree rooted
    // under idx. It assumes that subtrees of node are
    // already heapified.
    public static void maxHeapify(int[] arr, int n, int idx)
    {
        if (idx >= n)
            return;

        int l = 2 * idx + 1;
        int r = 2 * idx + 2;
        int max = idx;

        if (l < n && arr[l] > arr[idx])
            max = l;
        if (r < n && arr[r] > arr[max])
            max = r;

        if (max != idx) {
            int temp = arr[max];
            arr[max] = arr[idx];
            arr[idx] = temp;
            maxHeapify(arr, n, max);
        }
    }

    // Builds a max heap of given arr[0..n-1]
    public static void buildMaxHeap(int[] arr, int n)
    {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    // Merges max heaps a[] and b[] into merged[]
    public static int[] mergeHeaps(int[] a, int[] b, int n,
                                   int m)
    {
        // Merge both the arrays
        int[] merged = new int[n + m];
        for (int i = 0; i < n; i++)
            merged[i] = a[i];
        for (int i = 0; i < m; i++)
            merged[n + i] = b[i];

        buildMaxHeap(merged, n + m);
        return merged;
    }

    public static void main(String[] args)
    {
        // Sample Input
        int[] a = { 10, 5, 6, 2 };
        int[] b = { 12, 7, 9 };

        int n = a.length;
        int m = b.length;

        // Function call
        int[] merged = mergeHeaps(a, b, n, m);

        for (int i = 0; i < n + m; i++)
            System.out.print(merged[i] + " ");
    }
}