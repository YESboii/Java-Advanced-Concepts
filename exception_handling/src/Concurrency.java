public class Concurrency {
    public static void main(String[] args) {
        t t1 = new T(1);
        t t2 = new T(2);
        t2.start();
        t1.start();
    }
}
class t extends Thread{

    private int n;
    t(int n){
        this.n = n;
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("From Thread "+ this.n);
        }
    }
}

