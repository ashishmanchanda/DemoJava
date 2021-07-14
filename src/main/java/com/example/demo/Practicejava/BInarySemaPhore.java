package com.example.demo.Practicejava;

import java.util.concurrent.Semaphore;

class PrintJob2 implements Runnable{
    PrinterQueue3  printQueue;

     PrintJob2(PrinterQueue3 printerQueue){
         this.printQueue=printerQueue;
     }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
printQueue.printJob(new Object());
    }
}

class PrinterQueue3{
    Semaphore semaphore;
    PrinterQueue3(){
        this.semaphore=new Semaphore(1);
    }
    void printJob(Object o){
        try{
            semaphore.acquire();
            System.out.println("printing with"+Thread.currentThread());

        }catch (InterruptedException e){
            e.printStackTrace();

        }finally {
            System.out.println("releasing semaphore lock"+Thread.currentThread());
           semaphore.release();
        }
    }
}

public class BInarySemaPhore {
    public static void main(String[] args) {
        PrinterQueue3 printerQueue=new PrinterQueue3();
        Thread t[]=new Thread[50];
        for (int i=0;i<50;i++){
             t[i]=new Thread(new PrintJob2(printerQueue));
        }
        for(int i=0;i<50;i++){
            t[i].start();
        }
    }

}
