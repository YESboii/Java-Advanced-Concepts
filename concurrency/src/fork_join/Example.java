package fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Example {


     static public void main(String[] args) {
         ForkJoinPool forkJoinPool = new ForkJoinPool();
         Long start = System.currentTimeMillis();
         Integer n = forkJoinPool.invoke(new FibonacciRecursiveTask(15));
         FibonacciRecursiveTask t = new FibonacciRecursiveTask(15);
         t.fork();
         Long end = System.currentTimeMillis();
         System.out.println("nth :" + n);
         System.out.println((end-start)/1000.0);
    }
}
//f(n) = f(n-1) + f(n-2) f(0) = 0, f(1)=1
//
class FibonacciRecursiveTask extends RecursiveTask<Integer>{

    private final Integer n;
    public FibonacciRecursiveTask(Integer n){
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n<=1){
//            System.out.println(n);
            return n;
        }
        FibonacciRecursiveTask t1 = new FibonacciRecursiveTask(n-1);
        FibonacciRecursiveTask t2 = new FibonacciRecursiveTask(n-2);
        t1.fork();
        return t2.compute() + t1.join();
    }
}