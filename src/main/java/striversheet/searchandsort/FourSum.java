package striversheet.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;

class FourGfG {
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;

        // Sort the array to apply two-pointer approach
        Arrays.sort(arr);

        // Fix the first two elements
        for (int i = 0; i < n; i++) {
            // Skip duplicates for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for j
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                // Use two-pointer technique for remaining two elements
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum == target) {
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[k]);
                        quad.add(arr[l]);
                        res.add(quad);

                        k++;
                        l--;

                        // Skip duplicates for k
                        while (k < l && arr[k] == arr[k - 1]) k++;

                        // Skip duplicates for l
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    }
                    else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int target = 23;

        ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);

        for (ArrayList<Integer> v : ans) {
            for (int x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}