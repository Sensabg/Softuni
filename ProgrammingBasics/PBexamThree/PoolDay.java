package PBexamThree;

import java.util.Scanner;

public class PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfPeople = Integer.parseInt(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());
        double pricePerLounger = Double.parseDouble(scanner.nextLine());
        double pricePerUmbrella = Double.parseDouble(scanner.nextLine());

        double totalTax = amountOfPeople * tax;

        double loungerNeeded = Math.ceil(amountOfPeople * 0.75);
        double totalLoungerPrice = loungerNeeded * pricePerLounger;

        double totalUmbrellaNeeded = Math.ceil(amountOfPeople * 0.50);
        double totalUmbrellaPrice = totalUmbrellaNeeded * pricePerUmbrella;

        double totalPrice = totalTax + totalLoungerPrice + totalUmbrellaPrice;

        System.out.printf("%.2f lv.",totalPrice);

    }
}
