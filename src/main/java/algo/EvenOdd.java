package algo;

class EvenOdd {
    private int     number;
    private int     count;
    private boolean printOdd;

    private EvenOdd(int number, boolean printOdd, int initialValue) {
        this.number = number;
        this.printOdd = printOdd;
        this.count = initialValue;
    }

    private void printOddNumbers() throws InterruptedException {
        while (count <= number) {
            synchronized (this) {
                while (!printOdd) {
                    this.wait();
                }
                if (count < number) {
                    System.out.print("Odd Thread" + Thread.currentThread());
                    System.out.println(count);
                    count++;
                    printOdd = !printOdd;
                    this.notifyAll();
                }
            }
        }

    }

    private void printEvenNumbers() throws InterruptedException {
        while (count <= number) {
            synchronized (this) {
                while (printOdd) {
                    this.wait();
                }
                if (count <= number) {
                    System.out.print("Even Thread" + Thread.currentThread());
                    System.out.println(count);
                    count++;
                    printOdd = !printOdd;
                    this.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EvenOdd e = new EvenOdd(10, true, 1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    e.printOddNumbers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    e.printEvenNumbers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
