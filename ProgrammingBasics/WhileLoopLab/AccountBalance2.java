package WhileLoopLab;

import java.util.Scanner;

public class AccountBalance2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;

        while (!input.equals("NoMoreMoney")) {

            double inputConvert = Double.parseDouble(input);
            sum += inputConvert;


            if (inputConvert < 0) {
                System.out.println("\nInvalid operation!");
                break;
            }
            System.out.printf("\nIncrease: %.2f",inputConvert);
            input = scanner.nextLine();

        }

        System.out.printf("\nTotal: %.2f", sum);

    }
}
