package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class Multiplyby2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double number;

        while (true) {
            number = scanner.nextDouble();

            if (number < 0) {
                System.out.println("Negative number!");
                break;
            } else if ( number >= 0) {
                double result = number * 2;
                System.out.printf("Result: %.2f ", result);
            }
        }
        scanner.close();
    }
}
