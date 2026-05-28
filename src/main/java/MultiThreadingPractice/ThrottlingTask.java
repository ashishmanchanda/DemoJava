//package MultiThreadingPractice;
//
//import java.util.concurrent.*;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.TimeUnit;
//
//class BlockingThreadPoolExecutor extends ThreadPoolExecutor {
//    private final Semaphore semaphore;
//
//    public BlockingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
//                                      TimeUnit unit, BlockingQueue<Runnable> workQueue) {
//        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//        semaphore = new Semaphore(corePoolSize);
//    }
//
//    @Override
//    protected void beforeExecute(Thread t, Runnable r) {
//        super.beforeExecute(t, r);
//    }
//
//    @Override
//    public void execute(final Runnable task) {
//        boolean acquired = false;
//
//        do {
//            try {
//                semaphore.acquire();
//                acquired = true;
//            } catch (final InterruptedException e) {
//                e.printStackTrace();
//            }
//        } while (!acquired);
//
//        try {
//            super.execute(task);
//        } catch (final RejectedExecutionException e) {
//            System.out.println("Task Rejected");
//            semaphore.release();
//            return;
//        }
//        semaphore.release();
//    }
//
//    @Override
//    protected void afterExecute(Runnable r, Throwable t) {
//        super.afterExecute(r, t);
//        if (t != null) {
//            t.printStackTrace();
//        }
//    }
//}
//
//
//
//public class BlockingThreadPoolExecutorDemo {
//    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
//        BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(1, 1, 5000, TimeUnit.MILLISECONDS, blockingQueue);
//        executor.setRejectedExecutionHandler(new CustomRejectedExecutionHandler());
//
//        executor.prestartAllCoreThreads();
//
//        int threadCounter = 0;
//        while (true) {
//            threadCounter++;
//            // Adding threads one by one
//            System.out.println("Adding DemoTask : " + threadCounter);
//            blockingQueue.offer(new DemoTask(Integer.toString(threadCounter)));
//            if (threadCounter == 100)
//                break;
//        }
//
//        Thread.sleep(1000000);
//    }
//}
