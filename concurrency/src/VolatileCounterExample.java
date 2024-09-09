public class VolatileCounterExample {
    private volatile int count = 0;

    public void increment() {
        count++; // This operation is not atomic
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCounterExample example = new VolatileCounterExample();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + example.getCount());
    }
}
