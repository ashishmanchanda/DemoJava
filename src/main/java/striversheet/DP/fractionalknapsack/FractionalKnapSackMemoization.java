package striversheet.DP.fractionalknapsack;

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
////What is the time and space complexity of the above solution? Since our memoization array dp [profits. length] [capacity+1] stores the results for all the subproblems, we can conclude that we will not have more than N * C subproblems (where 'N is the number of items and 'C' is the knapsack capacity). This means that our time complexity will be
////        O(N * C).
//The above algorithm will be using O(N * C) space for the memoization array. Other than that we will use O (I) space for the recursion call-stack
//So the total space complexity will be O(N * C + N), which is asymptotically equivalent to O(N * C).
