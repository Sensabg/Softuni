package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String vipOrNormal = scanner.nextLine();
        int peopleAmount = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double transportPrice = 0;

        switch (vipOrNormal) {

            case "Normal":
                price = 249.99 * peopleAmount;
                if (peopleAmount <= 4) {
                    transportPrice = budget * 0.75;
                } else if (peopleAmount <= 9) {
                    transportPrice = budget * 0.60;
                } else if (peopleAmount <= 24) {
                    transportPrice = budget * 0.50;
                } else if (peopleAmount <= 49) {
                    transportPrice = budget * 0.40;
                } else {
                    transportPrice = budget * 0.25;
                }
                break;

            case "VIP":
                price = 499.99 * peopleAmount;
                if (peopleAmount <= 4) {
                    transportPrice = budget * 0.75;
                } else if (peopleAmount <= 9) {
                    transportPrice = budget * 0.60;
                } else if (peopleAmount <= 24) {
                    transportPrice = budget * 0.50;
                } else if (peopleAmount <= 49) {
                    transportPrice = budget * 0.40;
                } else {
                    transportPrice = budget * 0.25;
                }
                break;

        }
        double totalPrice = transportPrice + price;
        double enoughMoney = budget - totalPrice;

        if (budget > totalPrice) {
            System.out.printf("Yes! You have %.2f leva left.", Math.abs(enoughMoney));
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(enoughMoney));
        }
    }
}
