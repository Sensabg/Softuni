package ArraysMoreExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] cache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        cache = new long[n + 1];

        System.out.println(fibonacci(n));
    }
    private static long fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }

        long number = (fibonacci(n - 1) + fibonacci(n - 2));
        cache[n] = number;

        return number;
    }


}