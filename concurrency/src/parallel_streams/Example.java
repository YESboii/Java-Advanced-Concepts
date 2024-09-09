package parallel_streams;

import java.util.Arrays;
import java.util.List;


//Processed by the ForkJoinPool
public class Example {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        list.parallelStream()
                .map(s -> {
                    System.out.println("Mapping " + s + " by " + Thread.currentThread().getName());
                    return s;
                })
                .filter(s -> {
                    System.out.println("Filtering " + s + " by " + Thread.currentThread().getName());
                    return true;
                })
                .forEachOrdered(s -> {
                    System.out.println("ForEachOrdered " + s + " by " + Thread.currentThread().getName());
                });
    }
}
