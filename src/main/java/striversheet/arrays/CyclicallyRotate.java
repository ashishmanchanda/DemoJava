package striversheet.arrays;

import java.util.Arrays;

class CyclicallyGfG {
    static void rotate(int[] arr) {

        // i and j pointing to first and last
        // element respectively
        int i = 0, j = arr.length - 1;
        while (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }
}
