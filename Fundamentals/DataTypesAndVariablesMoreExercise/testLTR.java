package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class testLTR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int cycle = 0; cycle < input; cycle++) {
            long number1 = Long.parseLong(scanner.next());
            long number2 = Long.parseLong(scanner.next());

            long biggerNumber = Math.abs(Math.max(number1, number2));

            long sum = 0;
            while (Math.abs(biggerNumber) > 0) {
                long digit = biggerNumber % 10;
                sum += digit;
                biggerNumber /= 10;
            }
            sum += biggerNumber;
            System.out.printf("%d%n", sum);
        }
    }
}