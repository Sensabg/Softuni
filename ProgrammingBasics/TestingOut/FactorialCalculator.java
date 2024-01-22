package TestingOut;

import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a non-negative number: ");
        int number = scanner.nextInt();
        int result = 1;
        for (int i = number; i > 1; i--) {
            result *= i;

        }
        System.out.println("Factorial: " + result);
    }
}