package algo.DP.knapsackpattern;

class PartitionSet2 {

    public int canPartition(int[] num) {
        int dp[][]=new int[num.length][1000];
        return this.canPartitionRecursive(num, 0, 0, 0,dp);
    }

    private int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2,int dp[][]) {
        // base check
        if (currentIndex == num.length)
            return Math.abs(sum1 - sum2);
        // recursive call after including the number at the currentIndex in the first
        int diff1 = canPartitionRecursive(num, currentIndex + 1, sum1 + num[currentIndex], sum2,dp);
        // recursive call after including the number at the currentIndex in the secon
        int diff2 = canPartitionRecursive(num, currentIndex + 1, sum1, sum2 + num[currentIndex],dp);
        return Math.min(diff1, diff2);
    }

    public static void main(String[] args) {
        PartitionSet2 ps = new PartitionSet2();
        int[] num = { 1, 2, 3, 9 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 3, 100, 4 };
        System.out.println(ps.canPartition(num));
    }
}