package blocking_objects;

import java.util.concurrent.CountDownLatch;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch barrier = new CountDownLatch(3);
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting at barrier.");
                barrier.countDown();
                barrier.await(); // Wait for the barrier to be triggered
                System.out.println(Thread.currentThread().getName() + " passed the barrier.");
//                barrier.
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getClass());
            }
        };

        // Start 4 threads
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");
        Thread t4 = new Thread(task, "Thread 4");
        Thread t5 = new Thread(task, "Thread 5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
    }
}
