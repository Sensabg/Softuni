package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class FruitShop2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String food = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;

        if ("Monday".equals(day) || "Tuesday".equals(day) || "Wednesday".equals(day) ||
                "Thursday".equals(day) || "Friday".equals(day)) {
            switch (food) {
                case "banana":
                    price = 2.50;
                    break;
                case "apple":
                    price = 1.20;
                    break;
                case "orange":
                    price = 0.85;
                    break;
                case "grapefruit":
                    price = 1.45;
                    break;
                case "kiwi":
                    price = 2.70;
                    break;
                case "pineapple":
                    price = 5.50;
                    break;
                case "grapes":
                    price = 3.85;
                    break;
            }
        } else if ("Saturday".equals(day) || "Sunday".equals(day)) {
            switch (food) {
                case "banana":
                    price = 2.70;
                    break;
                case "apple":
                    price = 1.25;
                    break;
                case "orange":
                    price = 0.90;
                    break;
                case "grapefruit":
                    price = 1.60;
                    break;
                case "kiwi":
                    price = 3.00;
                    break;
                case "pineapple":
                    price = 5.60;
                    break;
                case "grapes":
                    price = 4.20;
                    break;
            }
        }

        double result = quantity * price;

        if (result > 0) {
            System.out.printf("%.2f", result);
        } else {
            System.out.println("error");
        }
    }
}
