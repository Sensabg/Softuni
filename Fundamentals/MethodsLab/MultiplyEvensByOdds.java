package MethodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(getMultipleOfEvenAndOddNumbers(num));
    }

    private static int getMultipleOfEvenAndOddNumbers(int num) {

        return evenSum(num) * oddSum(num);
    }

    private static int evenSum(int num) {
        int evenSum = 0;
        while (num != 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            num /= 10;
        }
        return evenSum;
    }

    private static int oddSum(int num) {
        int oddSum = 0;
        while (num != 0) {
            int digit = num % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            num /= 10;
        }
        return oddSum;
    }
}