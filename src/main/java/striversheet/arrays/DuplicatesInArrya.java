package striversheet.arrays;

import java.util.ArrayList;

class DuplicatesInArrayGfG {

    public static ArrayList<Integer> findDuplicates(int[] arr) {

        // convert value to index (1-based to 0-based)
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;

            // if already visited, it's a duplicate
            if (arr[idx] < 0) {
                ans.add(Math.abs(arr[i]));
            } else {

                // mark as visited
                arr[idx] = -arr[idx];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 3};
        ArrayList<Integer> res = findDuplicates(arr);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}