package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kilometersPerMonth = Double.parseDouble(scanner.nextLine());

        double kilometersPrice = 0;

        switch (season) {
            case "Spring":
            case "Autumn":
                if (kilometersPerMonth <= 5000) {
                    kilometersPrice = kilometersPerMonth * 0.75;
                } else if (kilometersPerMonth <= 10000) {
                    kilometersPrice = kilometersPerMonth * 0.95;
                }
                break;
            case "Summer":
                if (kilometersPerMonth <= 5000) {
                    kilometersPrice = kilometersPerMonth * 0.90;
                } else if (kilometersPerMonth <= 10000) {
                    kilometersPrice = kilometersPerMonth * 1.10;
                }
                break;
            case "Winter":
                if (kilometersPerMonth <= 5000) {
                    kilometersPrice = kilometersPerMonth * 1.05;
                } else if (kilometersPerMonth <= 10000) {
                    kilometersPrice = kilometersPerMonth * 1.25;
                }
                break;

        }
        if (kilometersPerMonth <= 20000 && kilometersPerMonth > 10000) {
            kilometersPrice = kilometersPerMonth * 1.45;
        }
        double price = kilometersPrice * 4;
        double totalPrice = price - (price * 0.10);
        System.out.printf("%.2f",totalPrice);

    }
}
