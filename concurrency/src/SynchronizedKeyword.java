import java.util.ArrayList;
import java.util.List;

public class SynchronizedKeyword {
    public static void main(String[] args) {
        Counterr counterr = new Counterr();
        Thread t1 = new Thread(() -> {while (true) {
            System.out.println("From 1");
            counterr.add();
        }}, "Thread 1");
        Thread t2 = new Thread(() -> {while (true) {
            System.out.println("From 2");
            counterr.getCounter();
        }}, "Thread 2");

        t1.start();
        t2.start();
    }
}

class Counterr{
    private List<Integer> list = new ArrayList<>();
    public synchronized void add() {
        if(list.size()<100){
            list.add(1);
        }
    }
    public synchronized void getCounter(){
        if(!list.isEmpty()){
             list.remove(0);
        }

    }
}