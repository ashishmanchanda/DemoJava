package DataStructuresPractice.Array;

// Java program to rearrange positive and negative numbers
// alternately using Two pointers

import java.util.ArrayList;
import java.util.List;

class RearrangePositiveNegative {

    // Function to rearrange positive and negative numbers
    // in alternate fashion
    static void rearrange(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positive and negative numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        int posIdx = 0, negIdx = 0;
        int i = 0;

        // Place positive and negative numbers alternately
        // in the original array
        while (posIdx < pos.size() && negIdx < neg.size()) {
            if (i % 2 == 0)
                arr[i++] = pos.get(posIdx++);
            else
                arr[i++] = neg.get(negIdx++);
        }

        // Append remaining positive numbers (if any)
        while (posIdx < pos.size())
            arr[i++] = pos.get(posIdx++);

        // Append remaining negative numbers (if any)
        while (negIdx < neg.size())
            arr[i++] = neg.get(negIdx++);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        rearrange(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
