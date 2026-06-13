package MultiThreadingPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

 class ThreadMemoryDemo {

    // ❌ HEAP — Instance variable (shared if same object used across threads)
    private int instanceCounter = 0;

    // ❌ HEAP — Static variable (shared across ALL threads in JVM)
    private static int staticCounter = 0;

    // ✅ HEAP but THREAD-SAFE — Atomic instance variable
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    // ✅ HEAP but THREAD-SAFE — Volatile (visibility guaranteed, not atomicity)
    private volatile boolean isRunning = true;

    // ❌ HEAP — Shared mutable collection
    private List<String> sharedList = new ArrayList<>();

    // ✅ HEAP but THREAD-SAFE — Concurrent collection
    private List<String> safeList = new CopyOnWriteArrayList<>();


    public void run() {

        // =============================================
        // ✅ STACK VARIABLES — Always Thread-Safe
        // =============================================

        int localPrimitive = 10;               // ✅ Stack — each thread gets own copy
        double localRate = 0.05;               // ✅ Stack — own copy per thread
        boolean localFlag = true;              // ✅ Stack — own copy per thread
        String localString = "thread-local";   // ✅ Reference on stack, not shared

        // New object created locally — not shared with other threads
        List<String> localList = new ArrayList<>();  // ✅ effectively thread-safe
        localList.add("item-" + localPrimitive);


        // =============================================
        // ❌ HEAP — Race Conditions (Unsafe Operations)
        // =============================================

        // PROBLEM: Read-Modify-Write is NOT atomic
        // Thread A reads count=5, Thread B reads count=5
        // Both write 6 → one increment is LOST
        instanceCounter++;       // ❌ Race condition
        staticCounter++;         // ❌ Race condition (even worse — all instances affected)

        // PROBLEM: ArrayList is not thread-safe
        sharedList.add("data"); // ❌ ConcurrentModificationException possible


        // =============================================
        // ✅ HEAP — Safe Operations (Proper Synchronization)
        // =============================================

        atomicCounter.incrementAndGet();   // ✅ Atomic — CAS operation, no lock needed
        safeList.add("safe-data");         // ✅ CopyOnWriteArrayList — thread-safe

        // ✅ volatile read — always reads latest value from main memory
        if (isRunning) {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        }

        // ✅ synchronized block — only one thread at a time
        synchronized (this) {
            instanceCounter++;  // ✅ Now safe inside synchronized block
        }

        // ✅ Local computation using heap value — safe because result stays on stack
        int localSnapshot = instanceCounter;   // snapshot copied to stack
        int computed = localSnapshot * 2;      // pure stack operation — safe
        System.out.println("Computed: " + computed);
    }


    // =============================================
    // Main — Launch multiple threads
    // =============================================
    public static void main(String[] args) throws InterruptedException {

        ThreadMemoryDemo demo = new ThreadMemoryDemo(); // ONE shared object

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                demo.run();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Expected: 3000 (3 threads × 1000 iterations)
        System.out.println("=== Final Results ===");
        System.out.println("instanceCounter (unsafe) : " + demo.instanceCounter);  // ❌ likely < 3000
        System.out.println("staticCounter   (unsafe) : " + staticCounter);         // ❌ likely < 3000
        System.out.println("atomicCounter   (safe)   : " + demo.atomicCounter);    // ✅ always 3000
        System.out.println("safeList size   (safe)   : " + demo.safeList.size());  // ✅ always 3000
    }
}
