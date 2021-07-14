package com.example.demo.Practicejava;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintJob implements Runnable {
    PrinterQueue printerQueue;
    PrintJob(PrinterQueue printerQueue){
        this.printerQueue=printerQueue;
    }

    @Override
    public void run() {
        printerQueue.print(new Object());

    }
}

class PrinterQueue{
    Lock queueLock=new ReentrantLock();
    void print(Object o){
        queueLock.lock();
        try
        {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds :: Time - " + new Date());
            Thread.sleep(duration);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
            queueLock.unlock();
        }

    }
}

class Test{
    public static void main(String[] args) {
        PrinterQueue queue=new PrinterQueue();
        Thread t[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
         t[i]=new Thread(new PrintJob(queue));
        }
        for (int i = 0; i < 10; i++) {
            t[i].start();
        }

    }
}
