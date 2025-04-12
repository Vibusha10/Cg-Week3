public class Program5 {

    public static void main(String[] args) {
        int n = 30;

        long startRecursive = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Result: " + resultRecursive);
        System.out.println("Recursive Time: " + (endRecursive - startRecursive) / 1_000_000 + " ms");

        long startIterative = System.nanoTime();
        int resultIterative = fibonacciIterative(n);
        long endIterative = System.nanoTime();
        System.out.println("Iterative Result: " + resultIterative);
        System.out.println("Iterative Time: " + (endIterative - startIterative) / 1_000_000 + " ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
