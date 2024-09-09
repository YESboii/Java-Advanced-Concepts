import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable r = () -> {System.out.println("hello from: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executorService.execute(r);
        System.out.println("Hello, World! from: " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5_000);
        System.out.println(Thread.currentThread().getName()+" 2");
        executorService.shutdown();

    }
}
