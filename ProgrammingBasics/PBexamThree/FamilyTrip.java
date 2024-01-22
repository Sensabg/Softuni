package PBexamThree;

import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int amountSleepOvers = Integer.parseInt(scanner.nextLine());
        double pricePerSleepOver = Double.parseDouble(scanner.nextLine());
        int additionalExpenses = Integer.parseInt(scanner.nextLine());

        if (amountSleepOvers > 7) {
            pricePerSleepOver = pricePerSleepOver - (pricePerSleepOver * 0.05);
        }

        double totalPriceForSleepOvers = pricePerSleepOver * amountSleepOvers;
        double priceForAdditionalExpenses = budget * (additionalExpenses * 0.01);

        double totalPriceNeeded = totalPriceForSleepOvers + priceForAdditionalExpenses;

        if(totalPriceNeeded <= budget){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.",budget - totalPriceNeeded);
        } else {
            System.out.printf("%.2f leva needed.", totalPriceNeeded - budget);
        }
    }
}
