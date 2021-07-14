package algo.DP.fibonaccipattern;

class Staircase {
    public int CountWays(int n) {
        if( n == 0)
            return 1; // base case, we don't need to take any step, so there is only on
        if(n == 1)
            return 1; // we can take one step to reach the end, and that is the only wa
        if(n == 2)
            return 2; // we can take one step twice or jump two steps to reach at the t
        int take1Step = CountWays(n-1);
        int take2Step= CountWays(n-2);
        int take3Step= CountWays(n-3);
        return take1Step + take2Step + take3Step;
    }
    public static void main(String[] args) {
        Staircase sc = new Staircase();
        System.out.println(sc.CountWays(3));
        System.out.println(sc.CountWays(4));
        System.out.println(sc.CountWays(5));
    }
    }
