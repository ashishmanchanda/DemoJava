package DS.array;
import java.util.Arrays;

 class StringSort {
    // function to print string in sorted order
    static void sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.print(String.valueOf(arr));
    }

    // Driver program to test above function
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        sortString(s);
    }
}

