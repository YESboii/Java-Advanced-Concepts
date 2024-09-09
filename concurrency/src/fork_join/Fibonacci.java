package fork_join;

public class Fibonacci {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int n = fibonacci(15);
        System.out.println("nth :" + n);
        Long end = System.currentTimeMillis();
        System.out.println(((end - start)/1000.0));
    }

    // Simple recursive method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base cases: fibonacci(0) = 0, fibonacci(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive call
    }
}

