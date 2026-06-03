package MultiThreadingPractice;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingQueue;


class STPTask implements Runnable {
    private final String name;

    public STPTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("STPTask [" + name + "] executed on : " + LocalDateTime.now().toString());
    }
}

 class CustomThreadPool {
    //Thread pool size
    private final int poolSize;
    //Internally pool is an array
    private final WorkerThread[] workers;
    // FIFO ordering
    private final LinkedBlockingQueue<Runnable> queue;
    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<Runnable>();
        workers = new WorkerThread[poolSize];
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }
    public void execute(Runnable STPTask) {
        synchronized (queue) {
            queue.add(STPTask);
            queue.notify();
        }
    }
    private class WorkerThread extends Thread {
        public void run() {
            Runnable STPTask;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    STPTask = (Runnable) queue.poll();
                }
                try {
                    STPTask.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
    public void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < poolSize; i++) {
            workers[i] = null;
        }
    }
}

 class CustomThreadPoolExample {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            STPTask s = new STPTask("STPTask " + i);
            System.out.println("Created : " + s.getName());
            customThreadPool.execute(s);
        }
    }
}
