package algo.backtracking;

public class RatMazePractice {
    static int n;

    static boolean solveRatMaze(int maze[][]){

        int sol[][]=new int[n][n];

        return util(maze,0,0,sol);
    }

    static boolean isValid(int [][] maze,int start,int end){

        if(start<=n-1 &&end <=n-1 && maze[start][end]==1){
            return true;
        }
        return false;

    }
    static boolean util(int[][]maze,int start,int end,int[][] sol){
        if(start==n-1 && end==n-1 && maze[start][end]==1){
            sol[start][end]=1;
            return  true;
        }

         if(isValid(maze,start,end)){
            if(sol[start][end]==1){
                return false;
            }
            sol[start][end]=1;
          if(  util(maze,start+1,end,sol))
              return true;
            if(util(maze,start,end+1,sol))
                return true;
            if(util(maze,start-1,end,sol))
                return true;
            if(util(maze,start,end-1,sol))
                return true;
            sol[start][end]=0;
            return false;
        }

return false;
    }
    public static void main(String[] args) {
        RatMaze rat = new RatMaze();
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        n=maze.length;
        System.out.println(solveRatMaze(maze));
    }
}
