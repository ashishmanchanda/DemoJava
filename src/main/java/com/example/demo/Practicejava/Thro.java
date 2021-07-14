package com.example.demo.Practicejava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CustomThreadPoolExecutor extends ThreadPoolExecutor{
    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            java.util.concurrent.RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }
}
class ThreadMain implements Runnable{
    @Override public void run() {
        System.out.println("task is running");
    }
}

 class Thro {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(10);
        CustomThreadPoolExecutor threadPoolExecutor=new CustomThreadPoolExecutor(2, 10, 10, TimeUnit.SECONDS, queue, new java.util.concurrent.RejectedExecutionHandler() {
            @Override public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Task has been rejected");
            }
        });
        while (true){
            threadPoolExecutor.execute(new ThreadMain());
        }

    }

}
