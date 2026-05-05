package striversheet.arrays;

class NumberAppearOnce {
    // Function to find the element that appears once using XOR
    public int getSingleElement(int[] arr) {
        int xorr = 0;

        // XOR all elements — duplicates cancel each other out
        for (int num : arr) {
            xorr ^= num;
        }

        return xorr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};

        NumberAppearOnce obj = new NumberAppearOnce();
        int ans = obj.getSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}

