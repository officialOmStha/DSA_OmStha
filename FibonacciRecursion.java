import java.util.Scanner;

public class FibonacciRecursion {

    // Recursive method to find nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;  // base cases: fib(0) = 0, fib(1) = 1
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci Series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
