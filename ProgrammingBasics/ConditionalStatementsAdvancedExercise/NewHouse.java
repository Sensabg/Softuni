package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int amountFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (flowerType) {
            case "Roses":
                price = amountFlowers * 5;

                if (amountFlowers > 80) {
                    price = price - (price * 0.10);
                }
                break;

            case "Dahlias":
                price = amountFlowers * 3.80;

                if (amountFlowers > 90) {
                    price = price - (price * 0.15);
                }
                break;

            case "Tulips":
                price = amountFlowers * 2.80;

                if (amountFlowers > 80) {
                    price = price - (price * 0.15);
                }

                break;
            case "Narcissus":
                price = amountFlowers * 3;

                if (amountFlowers < 120) {
                    price = price + (price * 0.15);
                }

                break;
            case "Gladiolus":
                price = amountFlowers * 2.50;

                if (amountFlowers < 80) {
                    price = price + (price * 0.20);
                }

                break;
        }

        double diff = Math.abs(budget - price);

        if (price <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", amountFlowers, flowerType, diff);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", diff);
        }
    }
}

