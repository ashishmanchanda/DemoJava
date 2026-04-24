package striversheet.recursion;

 class Power {

    static double power(double x,int n){
        if(n<0){
            return 1/power(x,-n);
        }
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n%2==0) {
            return power(x * x, n / 2);
        }
        else{
            return x * power(x, n - 1);
        }
    }
    public static void main(String[] args) {
        double x=2;
        int n=-3;
        double result= power(x,n);
        System.out.println(result);
    }
}
