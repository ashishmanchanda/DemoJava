package striversheet.stackandqueues;

public class CelebrityProblemOptimal {

    int celerity(int[][] M){
        int n=M.length;
        int top=0;
        int down=n-1;

        while(top<down) {
            if (M[top][down] == 1) {
                top++;
            }
            else if (M[down][top] == 1) {
                down--;
            }
            else {
                top++;
                down--;
            }

        }
        if(top>down){
            return -1;
        }
        for (int i=0;i<n;i++){
            if (i==top){
                continue;
            }
            if((M[top][i]==1 || M[i][top]==0)){
                return -1;
            }
        }
return top;
    }
    public static void main(String[] a){
        int[][] M = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };
        CelebrityProblemOptimal c = new CelebrityProblemOptimal();
        int ans=c.celerity(M);
        System.out.println(ans);

    }
}
