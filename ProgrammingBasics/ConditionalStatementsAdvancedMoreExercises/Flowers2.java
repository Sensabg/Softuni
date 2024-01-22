package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class Flowers2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int amountChrysanthemums = Integer.parseInt(scanner.nextLine());
        int amountRoses = Integer.parseInt(scanner.nextLine());
        int amountTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holidayOrNot = scanner.nextLine();

        int sumOfFlowers = amountChrysanthemums + amountRoses + amountTulips;

        double chrysanthemumPrice = 0.0;
        double rosesPrice = 0.0;
        double tulipsPrice = 0.0;

        if (season.equals("Spring") || season.equals("Summer")) {
            chrysanthemumPrice = amountChrysanthemums * 2.00;
            rosesPrice = amountRoses * 4.10;
            tulipsPrice = amountTulips * 2.5;
        } else if (season.equals("Autumn") || season.equals("Winter")) {
            chrysanthemumPrice = amountChrysanthemums * 3.75;
            rosesPrice = amountRoses * 4.50;
            tulipsPrice = amountTulips * 4.15;
        }
        double totalPrice = chrysanthemumPrice + rosesPrice + tulipsPrice;

        if (holidayOrNot.equals("Y")) {
            totalPrice += totalPrice * 0.15;
        }
        if (season.equals("Spring") && amountTulips >= 7) {
            totalPrice -= totalPrice * 0.05;
        }
        if (season.equals("Winter") && amountRoses >= 10) {
            totalPrice -= totalPrice * 0.10;
        }
        if (sumOfFlowers >= 20) {
            totalPrice -= totalPrice * 0.20;
        }
        System.out.printf("%.2f", totalPrice + 2);
    }
}


