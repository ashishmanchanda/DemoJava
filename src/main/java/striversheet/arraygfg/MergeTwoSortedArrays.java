package striversheet.arraygfg;

class MergeTwoSortedGfG {
    static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0;
        int[] merged = new int[n + m];

        // merge elements in sorted order
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // copy remaining elements from arr1
        while (i < n) merged[k++] = arr1[i++];

        // copy remaining elements from arr2
        while (j < m) merged[k++] = arr2[j++];

        // copy first n to arr1
        for (i = 0; i < n; ++i)
            arr1[i] = merged[i];

        // copy remaining m to arr2
        for (j = 0; j < m; ++j)
            arr2[j] = merged[n + j];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        mergeArrays(arr1, arr2);

        for (int num : arr1) System.out.print(num + " ");
        System.out.println();

        for (int num : arr2) System.out.print(num + " ");
        System.out.println();
    }
}
