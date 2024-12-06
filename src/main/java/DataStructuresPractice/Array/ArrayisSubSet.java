package DataStructuresPractice.Array;
import java.util.HashSet;
import java.util.Set;

class SubsetChecker {

    public static boolean isSubsetUsingHashing(int[] arr1,
                                               int[] arr2)
    {
        // Create a hash set and insert all elements of arr1
        Set<Integer> hashSet = new HashSet<>();
        for (int num : arr1) {
            hashSet.add(num);
        }

        // Check each element of arr2 in the hash set
        for (int num : arr2) {
            if (!hashSet.contains(num)) {
                return false;
            }
        }

        // If all elements of arr2 are found in the hash set
        return true;
    }

    public static void main(String[] args)
    {
        int[] arr1 = { 11, 1, 13, 21, 3, 7 };
        int[] arr2 = { 11, 3, 7, 1 };

        if (isSubsetUsingHashing(arr1, arr2)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
