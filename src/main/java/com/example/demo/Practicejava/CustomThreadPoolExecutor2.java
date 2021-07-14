package com.example.demo.Practicejava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

 class DemoTask implements Runnable
{
    private String name = null;

    public DemoTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing : " + name);
    }
}

class CustomThreadPoolExecutor2 extends ThreadPoolExecutor {

    CustomThreadPoolExecutor2(int corePoolSize, int maximumPoolSize,
            long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("Perform beforeExecute() logic");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            System.out.println("Perform exception handler logic");
        }
        System.out.println("Perform afterExecute() logic");
    }

}

class CustomThreadPoolExecutorMainClass {
    public static void main(String[] args) {
        Integer threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
        CustomThreadPoolExecutor2 customThreadPoolExecutor = new CustomThreadPoolExecutor2(10, 20, 1000, TimeUnit.MILLISECONDS, blockingQueue);
       customThreadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
           @Override public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
               System.out.println("DemoTask Rejected : "
                       + ((DemoTask) r).getName());
               System.out.println("Waiting for a second !!");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("Lets add another time : "
                       + ((DemoTask) r).getName());
               executor.execute(r);
           }
       });
        // Let start all core threads initially
        customThreadPoolExecutor.prestartAllCoreThreads();
        while (true) {
            threadCounter++;
            // Adding threads one by one
            System.out.println("Adding DemoTask : " + threadCounter);
            customThreadPoolExecutor.execute(new DemoTask(threadCounter.toString()));

            if (threadCounter == 100)
                break;
        }
    }
}