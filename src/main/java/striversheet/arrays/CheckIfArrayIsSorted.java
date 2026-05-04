package striversheet.arrays;

class Sorted {
    // Function to check if the array is sorted
    public boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])  // If any element is smaller than the previous one, return false
                return false;
        }
        return true;  // Return true if the array is sorted
    }
}

 class SortedMain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        Sorted obj = new Sorted();

        // Output result
        System.out.println(obj.isSorted(arr, n) ? "True" : "False");
    }
}
