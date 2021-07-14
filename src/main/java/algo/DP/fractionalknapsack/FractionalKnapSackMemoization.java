package algo.DP.fractionalknapsack;

class Knapsack1 {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int dp[][]=new int[profits.length][capacity+1];
        return this.knapsackRecursive(dp,profits, weights, capacity, 0);
    }
    private int knapsackRecursive(int[][]dp,int[] profits, int[] weights, int capacity, int currentIndex){
        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length || currentIndex >= profits.length)
            return 0;
        // recursive call after choosing the items at the currentIndex, note that we
        // items as we did not increment currentIndex
        int profit1 = 0;
        if(dp[currentIndex][capacity]==0) {
            if (weights[currentIndex] <= capacity)
                profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights, capacity - weights[currentIndex], currentIndex);
            // recursive call after excluding the element at the currentIndex
            int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
            dp[currentIndex][capacity]=Math.max(profit1, profit2);
        }
      return dp[currentIndex][capacity];
    }
    public static void main(String[] args) {
        Knapsack1 ks = new Knapsack1();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
