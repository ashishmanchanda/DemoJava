package striversheet.recursion;

public class CountGoodNumbers {
    public int MOD = 1000000007;

    static int countGoodNumbers(int index, int n) {
        if (index == n) return 1;
        int result = 0;
        if (index % 2 == 0) {
            int[] evennumbers = {0, 2, 4, 6, 8};
            for (int digits : evennumbers) {
                result = result + countGoodNumbers(index + 1, n);
            }
        } else {
            int[] oddnumbers = {2,3,5,7};
            for (int digits : oddnumbers) {
                result = result + countGoodNumbers(index + 1, n);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(0, 2));
    }
}
