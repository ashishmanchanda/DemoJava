package algo;

import java.util.Objects;

class ThreeThreads {
    int numCount=1;
    int capCount=1;
    int smallCount=1;
    boolean printNumber=true;
    boolean printCapital;
    boolean printSmall;
     Object lock=new Object();


ThreeThreads(){
    this.numCount=1;
    this.capCount=1;
    this.smallCount=1;
    this.printNumber=true;
    this.printCapital=false;
    this.printSmall=false;
    this.lock=new Object();
}

     void printNumbers() {
        synchronized (lock) {
            while(numCount<27) {
                while (!printNumber) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }

                }

                System.out.print(numCount++);
                printNumber = false;
                printCapital = true;
                printSmall = false;
                lock.notifyAll();
            }
        }
    }


     void printCapital(){
        synchronized (lock){
            while (capCount<27) {
                while (!printCapital) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }

                }

                System.out.print((char) ((capCount++) + 64));
                printCapital = false;
                printSmall = true;
                printNumber = false;
                lock.notifyAll();
            }
        }

    }


    void printSmall(){
        synchronized (lock){
            while (smallCount<27){
            while (!printSmall){
                try {
                    lock.wait();
                }catch (Exception e){

                }

            }

            System.out.println((char)((smallCount++) +96));
            printSmall=false;
            printNumber=true;
            printCapital=false;
            lock.notifyAll();

        }
    }

    }
    public static void main(String[] args) {
        ThreeThreads t=new ThreeThreads();


        Thread t1=new Thread(new Runnable() {
            @Override public void run() {

                t.printNumbers();
            }});

        Thread t2=new Thread(new Runnable() {
            @Override public void run() {

                t.printCapital();
            }});

        Thread t3=new Thread(new Runnable() {
            @Override public void run() {

                t.printSmall();
            }});

    t1.start();
    t2.start();
    t3.start();
    try {
        t1.join();
        t2.join();
        t3.join();
    }catch (Exception e){

    }


    }
}
