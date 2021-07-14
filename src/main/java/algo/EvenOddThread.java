package algo;

class PrintEvenOdd {
    boolean printOdd;
    int     start;
    int     limit;

    PrintEvenOdd(boolean printOdd, int start, int limit) {
        this.printOdd = printOdd;
        this.start = start;
        this.limit = limit;
    }

    void printOdd() {
        synchronized (this) {
            while (!printOdd) {
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            while (start < limit) {
                System.out.println(start);
                start++;
                printOdd = !printOdd;
                this.notifyAll();
            }
        }

    }

    void printEven() {
        synchronized (this) {
            while (printOdd) {
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            while (start < limit) {
                System.out.println(start);
                start++;
                printOdd = !printOdd;
                this.notifyAll();
            }
        }

    }

    public static void main(String a[]) throws InterruptedException {
        PrintEvenOdd p = new PrintEvenOdd(true, 1, 10);

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                p.printEven();

            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                p.printOdd();

            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

}
