package algo.DP;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FibonacciWithDP {
  private int fib(int n,int[] dif){
      if(n==0)
          return 0;
      else if(n==1){
          return 1;
      }else if(dif[n]!=-1){
        return dif[n];
      }  else{
         return dif[n]= (fib(n-1,dif) + fib(n-2,dif));
      }
  }
    public static void main(String[] args) {
 /*     int[] dif=new int[]{-1,-1,-1,-1,-1,-1,-1,-1};
      FibonacciWithDP f=new FibonacciWithDP();
        System.out.println(f.fib(7,dif));*/
        SimpleDateFormat maquetteDateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        System.out.println((maquetteDateformat.format(new Timestamp(System.currentTimeMillis()))));
    }
}
