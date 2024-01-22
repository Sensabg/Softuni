package WhileLoopMoreExercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chemical = Integer.parseInt(scanner.nextLine());
        int amountChemical = chemical * 750;

        int counter = 0;

        int dishes = 0;
        int pots = 0;

        int chemistryForDishes = 0;
        int chemistryForPots = 0;

        boolean notEnoughChemical = false;

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int stuff = Integer.parseInt(input);
            counter++;

            if (counter % 3 == 0) {
                pots += stuff;
                chemistryForPots += 15 * stuff;
            } else {
                dishes += stuff;
                chemistryForDishes += 5 * stuff;
            }

            if (amountChemical < chemistryForDishes + chemistryForPots) {
                notEnoughChemical = true;
                break;
            }

            input = scanner.nextLine();
        }

        int diff = Math.abs(amountChemical - (chemistryForDishes + chemistryForPots));

        if (notEnoughChemical) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", diff);
        } else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.", dishes, pots);
            System.out.printf("\nLeftover detergent %d ml.", diff);
        }
    }
}
