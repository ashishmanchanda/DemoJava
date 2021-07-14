package algo;

import java.util.*;

 class SimpleMovingAverage {

    // queue used to store list so that we get the average
    private final Queue<Double> Dataset = new LinkedList<Double>();
    private final int period;
    private double sum;

    // constructor to initialize period
    public SimpleMovingAverage(int period)
    {
        this.period = period;
    }

    // function to add new data in the
    // list and update the sum so that
    // we get the new mean
    public void addData(double num)
    {
        sum += num;
        Dataset.add(num);

        // Updating size so that length
        // of data set should be equal
        // to period as a normal mean has
        if (Dataset.size() > period)
        {
            sum -= Dataset.remove();
        }
    }

    // function to calculate mean
    public double getMean()
    {
        return sum / period;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int n=sc.nextInt();
       // double[] input_data = { 1, 3, 5, 6, 8,
             //   12, 18, 21, 22, 25 };
         double input_data[]=new double[n];
        double input_datax[]=new double[n];
        double input_datay[]=new double[n];
        for(int i=0;i<n;i++){
            input_data[i]=sc1.nextDouble();
        }

        SimpleMovingAverage obj = new SimpleMovingAverage(x);
        int count=0;
        for (double temp : input_data) {
            obj.addData(temp);
            input_datax[count]=obj.getMean();
           // System.out.println("x"+input_datax[count]);
            count++;

        }


        SimpleMovingAverage obj1 = new SimpleMovingAverage(y);
        count=0;
        for (double temp : input_data) {
            obj1.addData(temp);
            input_datay[count]=obj1.getMean();
          //  System.out.println("y"+input_datay[count]);
            count++;
        }
        int max=x>y?x:y;
        int f=x>y?0:1;
        int result=0;
        for(int i=0;i<n;i++){
            if(f==1 && input_datay[i]>input_datax[i]){
                result++;
                f=0;
            }
            if(f==0 && input_datax[i]>input_datay[i]){
                result++;
                f=1;
            }
        }
        System.out.println(result);
    }
}
