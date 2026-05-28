package striversheet.heapgfg;

class BuildHeapGfG {

    // To heapify a subtree
    static void heapify(int arr[], int n, int i)
    {
        // Initialize largest as root
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Function to build a Max-Heap from the given array
    static void buildHeap(int arr[])
    {

        int n = arr.length;

        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args)
    {
        // Binary Tree Representation
        // of input array
        //             1
        //           /    \
        //         3        5
        //       /  \     /  \
        //     4      6  13  10
        //    / \    / \
        //   9   8  15 17
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};

        int n = arr.length;
        // Function call
        buildHeap(arr);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Final Heap:
        //              17
        //            /    \
        //          15      13
        //         /  \     / \
        //        9     6  5   10
        //       / \   / \
        //      4   8 3   1
    }
}
