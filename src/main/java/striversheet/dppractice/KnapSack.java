package striversheet.dppractice;

public class KnapSack {

    public int solve( int[] profits, int[] weights,int capacity) {
        return this.knapSackRecursive(profits,weights,capacity,0);
    }
    int  knapSackRecursive(int[] profits, int[] weights, int capacity, int currentIndex){
        if(capacity<=0 || currentIndex >=profits.length){
            return 0;
        }
         int profits1=0;
        if(weights[currentIndex]<=capacity){
            profits1=profits[currentIndex]+ knapSackRecursive(profits,weights,capacity-weights[currentIndex],currentIndex+1);
        }
        int profits2= knapSackRecursive(profits,weights,capacity,currentIndex+1);
        return Math.max(profits1,profits2);

    }

    public static void main(String[] args) {
        KnapSack ks = new KnapSack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        int maxProfit = ks.solve(profits, weights, 7);
        System.out.println(maxProfit);
    }
}
