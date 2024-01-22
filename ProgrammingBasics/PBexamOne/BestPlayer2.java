package PBexamOne;

import java.util.Scanner;

public class BestPlayer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double bestgoals = Integer.MIN_VALUE;
        String bestPlayer = "";

        while (!input.equals("END")) {
            int goals = Integer.parseInt(scanner.nextLine());

            if (goals > bestgoals) {
                bestgoals = goals;
                bestPlayer = input;
                if (bestgoals >= 10) {
                    break;
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("%s is the best player!%n", bestPlayer);
        if (bestgoals >= 3) {
            System.out.printf("He has scored %.0f goals and made a hat-trick !!!", bestgoals);
        } else {
            System.out.printf("He has scored %.0f goals.", bestgoals);
        }

    }
}