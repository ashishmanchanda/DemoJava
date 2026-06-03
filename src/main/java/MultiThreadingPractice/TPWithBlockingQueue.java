package MultiThreadingPractice;
import java.util.concurrent.*;

class PDemoTask implements Runnable {
    private String name = null;
    public PDemoTask(String name) {
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


 class DemoExecutor {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> blockingQueue =
                new LinkedBlockingQueue<Runnable>();
        CustomThreadPoolExecutor executor =
                new CustomThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS,
                        blockingQueue, new ThreadPoolExecutor.AbortPolicy());
        // Let start all core threads initially
        executor.prestartAllCoreThreads();
        for (int i = 1; i <= 100; i++) {
            blockingQueue.offer(new PDemoTask("Task " + i));
        }
        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
