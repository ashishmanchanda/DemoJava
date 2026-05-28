package striversheet.DP.knapsackpattern;

class ZeroOneKnapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer [] [] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursive(dp,profits, weights, capacity, 0);
    }
    private int knapsackRecursive(Integer [][] dp, int[] profits, int[] weights,int capacity, int currentIndex) {
// base checks
        if (capacity <= 0 || currentIndex > profits. length)
            return 0;
        int profit1 = 0;
        if (weights [currentIndex] <= capacity ){
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);
        }
// recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex);
                dp [currentIndex] [capacity] = Math.max (profit1, profit2);
        return dp [currentIndex] [capacity];
    }
    public static void main(String[] args) {
        Knapsack ks = new Knapsack () ;
        int[] profits = {1, 6, 10, 16};
    int [] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 7);
System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
System.out.println("Total knapsack profit ---> " + maxProfit);
}
}