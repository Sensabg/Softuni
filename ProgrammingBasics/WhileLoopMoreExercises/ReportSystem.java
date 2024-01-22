package WhileLoopMoreExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int expectedSum = Integer.parseInt(scanner.nextLine());

        int handOrCardCounter = 0;

        int handPayment = 0;
        int cardPayment = 0;

        int handCounter = 0;
        int cardCounter = 0;

        boolean success = false;

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int outcomes = Integer.parseInt(input);
            handOrCardCounter++;

            if (handOrCardCounter % 2 == 0) {
                if (outcomes < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    cardCounter++;
                    cardPayment += outcomes;
                    System.out.println("Product sold!");
                }
            } else {
                if (outcomes > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    handCounter++;
                    handPayment += outcomes;
                    System.out.println("Product sold!");
                }
            }

            if (handPayment + cardPayment >= expectedSum) {
                success = true;
                break;
            }

            input = scanner.nextLine();
        }

        double averageCard = cardPayment / (cardCounter * 1.0);
        double averageHand = handPayment / (handCounter * 1.0);

        if (success) {
            System.out.printf("Average CS: %.2f", averageHand);
            System.out.printf("\nAverage CC: %.2f", averageCard);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
