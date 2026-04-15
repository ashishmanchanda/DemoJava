package javamultithreading;

import java.util.concurrent.*;

 class ThrottlingDemo {
    public static void main(String[] args) throws InterruptedException {
        int maxThreads = 5;
        int queueCapacity = 10;

        ThrottledExecutor exec = new ThrottledExecutor(maxThreads, queueCapacity);

        for (int i = 0; i < 50; i++) {
            final int taskId = i;
            exec.submit(() -> {
                System.out.println("Running task " + taskId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);  // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            System.out.println("Submitted task " + i);
        }

        exec.shutdown();
        exec.executor.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("All done");
    }

    static class ThrottledExecutor {
        private final ThreadPoolExecutor executor;
        private final Semaphore semaphore;

        public ThrottledExecutor(int maxThreads, int queueCapacity) {
            BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(queueCapacity);
            this.executor = new ThreadPoolExecutor(
                    maxThreads, maxThreads, 0L, TimeUnit.MILLISECONDS,
                    queue,
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );
            this.semaphore = new Semaphore(maxThreads + queueCapacity);
        }

        public void submit(Runnable task) throws InterruptedException {
            semaphore.acquire();
            try {
                executor.execute(() -> {
                    try {
                        task.run();
                    } finally {
                        semaphore.release();
                    }
                });
            } catch (RejectedExecutionException rex) {
                semaphore.release();
                throw rex;
            }
        }

        public void shutdown() {
            executor.shutdown();
        }
    }
}

