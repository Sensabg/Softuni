package MethodsExercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            if (isDivisibleBy8(i) && hasAnOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isDivisibleBy8(int num) {
        int sum = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            sum += lastDigit;
            num /= 10;
        }
        return sum % 8 == 0;
    }

    public static boolean hasAnOddDigit(int num) {
        while (num != 0) {
            int lastDigit = num % 10;
            if (lastDigit % 2 != 0) {
                return true;
            } else {
                num /= 10;
            }
        }
        return false;
    }
}