package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String negativePositive = scanner.nextLine();

        days = days - 1;
        double price = 0.0;

        switch (room) {
            case "room for one person":
                price = 18.00 * days;

                break;
            case "apartment":
                price = 25.00 * days;
                if (days < 10) {
                    price = price - (price * 0.30);
                } else if (days > 10 && days < 15) {
                    price = price - (price * 0.35);
                } else {
                    price = price - (price * 0.50);
                }
                break;
            case "president apartment":
                price = 35.00 * days;
                if (days < 10) {
                    price = price - (price * 0.10);
                } else if (days > 10 && days < 15) {
                    price = price - (price * 0.15);
                } else {
                    price = price - (price * 0.20);
                }
                break;
        }
        switch (negativePositive) {
            case "negative":
                price = price - (price * 0.10);
                break;
            case "positive":
                price = price + (price * 0.25);
                break;
        }

        System.out.printf("%.2f",price);
    }
}
