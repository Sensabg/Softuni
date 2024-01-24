package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int strongNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int number = strongNumber;

        while (number > 0) {
           int digit = number % 10;
            int factorial = 1;
            for (int i = 1; i <= digit; i++) {
                factorial *= i;
            }

            sum += factorial;
            number /= 10;
        }

        if (strongNumber == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
