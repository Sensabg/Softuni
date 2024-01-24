package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int daysOperated = 0;
        int totalSpiceExtracted = 0;

        while (startingYield >= 100) {
            totalSpiceExtracted += startingYield - 26;
            startingYield -= 10;
            daysOperated++;
        }

        if (totalSpiceExtracted >= 26) {
            totalSpiceExtracted -= 26;
        }

        System.out.println(daysOperated);
        System.out.println(totalSpiceExtracted);
    }
}