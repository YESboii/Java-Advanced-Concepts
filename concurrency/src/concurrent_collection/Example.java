package concurrent_collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example {
    public static void main(String[] args) throws InterruptedException{

                List<String> list = new CopyOnWriteArrayList<>();
                list.add("A");
                list.add("B");
                list.add("C");

                // Thread 1 adds "D"
                Thread t1 = new Thread(() -> {
                    list.add("D");
                    System.out.println("Thread 1 added D");
                });

                // Thread 2 adds "Z"
                Thread t2 = new Thread(() -> {
                    list.add("Z");
                    System.out.println("Thread 2 added Z");
                });

                t1.start();
                t2.start();

                t1.join();
                t2.join();




    }
}
