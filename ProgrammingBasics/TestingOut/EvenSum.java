package TestingOut;

import java.util.Scanner;

public class EvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println("Sum of even numbers: " + sum);
            }
        }


    }
}
