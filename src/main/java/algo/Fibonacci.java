package algo;

public class Fibonacci {
    Integer printFibonacci(Integer n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        return printFibonacci(n-1)+printFibonacci(n-2);
    }

   void printFibonacci(int input,int start){
        if(start>input){
            return;
        }else{
        //    getFibonacci(start++);
        }
    }



    public static void main(String[] args) {
        Fibonacci f=new Fibonacci();
        f.printFibonacci(5);

    }
}

