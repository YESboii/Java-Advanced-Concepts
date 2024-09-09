import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//
public class ttt {

    static int a = 0;
    public static void main(String[] args)throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public  void run(){
                int i = 1;
                while(i<=1000){
                    a++;
                    i++;
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public  void run(){
                int i=1;
                while(i<=1000){
                    a++;
                    i++;
                }
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.shutdown();

        executorService.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println(a);
    }
}

