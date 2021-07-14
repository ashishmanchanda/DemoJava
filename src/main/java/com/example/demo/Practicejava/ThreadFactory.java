package com.example.demo.Practicejava;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class  Task2 implements Runnable{
    @Override public void run() {
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){

        }
    }
}
 class CustomThreadFactory implements ThreadFactory {
     int counter;
     private String       name;
     private List<String> stats;

     CustomThreadFactory(String name) {
         counter = 1;
         this.name = name;
         stats = new ArrayList<>();
     }

     @Override public Thread newThread(Runnable r) {
         Thread t = new Thread(r, name + "-Thread_" + counter);
         counter++;
         stats.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date()));
         return t;
     }

     public String getStats() {
         StringBuffer buffer = new StringBuffer();
         Iterator<String> it = stats.iterator();
         while (it.hasNext()) {
             buffer.append(it.next());
         }
         return buffer.toString();
     }
     public static void main(String[] args)
     {
         CustomThreadFactory factory = new CustomThreadFactory("CustomThreadFactory");
         Task2 task = new Task2();
         Thread thread;
         System.out.printf("Starting the Threads\n\n");
         for (int i = 1; i <= 10; i++)
         {
             thread = factory.newThread(task);
             thread.start();
         }
         System.out.printf("All Threads are created now\n\n");
         System.out.printf("Give me CustomThreadFactory stats:\n\n" + factory.getStats());
     }
 }


