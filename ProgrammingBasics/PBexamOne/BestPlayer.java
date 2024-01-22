package PBexamOne;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String name = scanner.nextLine();
        String bestPlayer = "";
        int amountGoals = 0;
        int currentGoals = 0;

        while (!name.equals("END")) {
            amountGoals = Integer.parseInt(scanner.nextLine());

            if (amountGoals > currentGoals) {
                bestPlayer = name;
            }

            currentGoals = amountGoals;
            if (amountGoals >= 3) {
                bestPlayer = name;

                if (amountGoals >= 10) {
                    bestPlayer = name;
                    break;
                }
            }
            name = scanner.nextLine();
        }

        System.out.printf("%s is the best player!", bestPlayer);

        if (amountGoals >= 3) {
            System.out.printf("\nHe has scored %d goals and made a hat-trick !!!", amountGoals);
        } else {
            System.out.printf("\nHe has scored %d goals.", amountGoals);
        }
    }
}
