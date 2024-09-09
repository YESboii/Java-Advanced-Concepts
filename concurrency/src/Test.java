import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    static  int counter = 0;
    static AtomicInteger atomicCounter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () ->{ int i = 1;
            while (i<=1000) {
                Test.counter++;
                atomicCounter.incrementAndGet();
                i++;
            }};
        Runnable r2 = () ->{ int i = 1;
            while (i<=1000) {
                Test.counter++;
                atomicCounter.incrementAndGet();
                i++;
            }};
        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r2,"t2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(r1);
        executorService.submit(r2);

        Thread.sleep(10_000);

        System.out.println(counter+" "+ atomicCounter.get());

        executorService.shutdown();
    }
}


