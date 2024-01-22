package PBexamOne;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        double luggagePriceOver20kg = Double.parseDouble(scanner.nextLine());
        double kg = Double.parseDouble(scanner.nextLine());
        int amountDays = Integer.parseInt(scanner.nextLine());
        int amountPackages = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (kg < 10) {
            price = luggagePriceOver20kg * 0.20;
        } else if (kg <= 20) {
            price = luggagePriceOver20kg * 0.50;
        } else {
            price = luggagePriceOver20kg;
        }

        if (amountDays < 7) {
            price = price * 1.40;
        } else if (amountDays <= 30) {
            price = price * 1.15;
        } else {
            price = price * 1.10;
        }

        double totalPrice = price * amountPackages;

        System.out.printf("The total price of bags is: %.2f lv.", totalPrice);

    }
}
