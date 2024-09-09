import java.util.List;
import java.util.ArrayList;

public class ProducerConsumer {


    public static void main(String[] args) {
        Producer p1  = new Producer("p1");
        Producer p2  = new Producer("p2");
        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");

        p1.start();
        c1.start();
    }
}

class Resource {
    public static final int MAX_SIZE = 100;
    public static final List<Integer> sharedResource = new ArrayList<>();
}

class Producer extends Thread {

    Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Resource.sharedResource) {
                    while (Resource.sharedResource.size() == Resource.MAX_SIZE) {
                        // Wait until there is space in the resource
                        Resource.sharedResource.wait();
                    }
//                    // Produce an item
                    Resource.sharedResource.add(1);
                    System.out.println("Produced by " + Thread.currentThread().getName() + " - Size: " + Resource.sharedResource.size());
                    Resource.sharedResource.notifyAll();
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {

    Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Resource.sharedResource) {
                    // Always invoke wait inside a loop that tests for the condition being waited for.
                    //in case if we use (if block) the condition won't be rechecked and will continue to execute
                    // ,because it still might be the case that the condition(that you were waiting for) is still true
                    while (Resource.sharedResource.size() == 0) {
                        // Wait until there is an item to consume
                        Resource.sharedResource.wait();
                    }
                    // Consume an item
                    Resource.sharedResource.remove(0);
                    System.out.println("Consumed by " + Thread.currentThread().getName() + " - Size: " + Resource.sharedResource.size());
                    // Notify producers that there is space available
                    Resource.sharedResource.notifyAll();
                }
                // Simulate time taken to consume an item
//                Thread.sleep(150);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            e.printStackTrace();
        }
    }
}
