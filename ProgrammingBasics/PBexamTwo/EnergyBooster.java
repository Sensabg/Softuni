package PBexamTwo;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String setSize = scanner.nextLine();
        int amountSets = Integer.parseInt(scanner.nextLine());

        double price = 0;
        int size = 0;

        switch (setSize) {
            case "big":
                size = 5;
                switch (fruit) {
                    case "Watermelon":
                        price = (size * 28.70) * amountSets;
                        break;
                    case "Mango":
                        price = (size * 19.60 * amountSets);
                        break;
                    case "Pineapple":
                        price = (size * 24.80) * amountSets;
                        break;
                    case "Raspberry":
                        price = (size * 15.20) * amountSets;
                        break;
                }
                break;
            case "small":
                size = 2;
                switch (fruit) {
                    case "Watermelon":
                        price = (size * 56) * amountSets;
                        break;
                    case "Mango":
                        price = (size * 36.66) * amountSets;
                        break;
                    case "Pineapple":
                        price = (size * 42.10) * amountSets;
                        break;
                    case "Raspberry":
                        price = (size * 20) * amountSets;
                        break;
                }
                break;
        }
        if (price >= 400 && price <= 1000) {
            price = price - (price * 0.15);
        } else if (price > 1000) {
            price = price / 2;
        }

        System.out.printf("%.2f lv.", price);
    }
}
