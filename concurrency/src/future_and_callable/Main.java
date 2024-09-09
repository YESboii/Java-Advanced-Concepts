package future_and_callable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args)throws Exception {
        Callable<Long> callable = () -> {
            long i = 0;
            if(i<1)
            throw new Exception("jaan buj k");
            for (int j = 1 ;j <= 1000000000L;j++){
                i+=j;
            }
            return i;
        };
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Long> ans = service.submit(callable);
        while(!ans.isDone()){
            System.out.println("computing");
        }
        try{
            Long a = ans.get();
            System.out.println(a);
        }catch (InterruptedException  | ExecutionException e){
            Throwable[] t = e.getSuppressed();
            System.out.println(e.toString());
            System.out.println(e.getSuppressed().length);
            System.out.println(e.getCause());
            for (Throwable tt:
                  t) {
                System.out.println(tt.getMessage());
            }
        }
        service.shutdown();
    }
}
