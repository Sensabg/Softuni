package FirstStepsInCodingEx;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountNylon = Integer.parseInt(scanner.nextLine());
        int amountDye = Integer.parseInt(scanner.nextLine());
        int amountThinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double nylon = 1.50;
        double dye = 14.50;
        double thinner = 5.00;

        double nylonPrice = (amountNylon + 2) * nylon;
        double dyePrice = (amountDye + (amountDye * 0.10)) * dye;
        double thinnerPrice = amountThinner * thinner;

        double price =  nylonPrice + dyePrice + thinnerPrice + 0.40;
        double priceWorkers = ( price * 0.30) * hours;

        double totalPrice = price + priceWorkers;

        System.out.println(totalPrice);
    }
}
