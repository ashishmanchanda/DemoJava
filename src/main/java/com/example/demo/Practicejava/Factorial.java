package com.example.demo.Practicejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class FactorialCalculator implements java.util.concurrent.Callable{
    int number;
    FactorialCalculator(int number){
        this.number=number;

    }
    @Override public Object call() throws Exception {
        int result=1;
        if(result==0 || result==1){
                result=1;
        }else {
            for(int i=2;i<=number;i++){
             result = result*i;
                TimeUnit.MILLISECONDS.sleep(20);
                System.out.println("Result for number - " + number + " -> " + result);
                return result;
            }
        }
        return result;
    }
};

 class CallableExample
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();

        for (int i=0; i<4; i++)
        {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator  = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        for(Future<Integer> future : resultList)
        {
            try
            {
                System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }
}
