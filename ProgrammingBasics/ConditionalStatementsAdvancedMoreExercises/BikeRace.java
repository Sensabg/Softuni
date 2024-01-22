package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int juniorBikers = Integer.parseInt(scanner.nextLine());
        int seniorBikers = Integer.parseInt(scanner.nextLine());
        String path = scanner.nextLine();

        double priceJ = 0;
        double priceS = 0;
        double totalPrice = 0;
        switch (path) {
            case "trail":
                priceJ = 5.50 * juniorBikers;
                priceS = 7 * seniorBikers;
                totalPrice = (priceJ + priceS);
                break;
            case "cross-country":
                priceJ = 8 * juniorBikers;
                priceS = 9.50 * seniorBikers;
                if (seniorBikers + juniorBikers >= 50) {
                    totalPrice = (priceJ + priceS) - ((priceJ + priceS) * 0.25);
                } else {
                    totalPrice = (priceJ + priceS);
                }
                break;
            case "downhill":
                priceJ = 12.25 * juniorBikers;
                priceS = 13.75 * seniorBikers;
                totalPrice = (priceJ + priceS);
                break;
            case "road":
                priceJ = 20 * juniorBikers;
                priceS = 21.50 * seniorBikers;
                totalPrice = (priceJ + priceS);
                break;
        }

        double finalPrice = totalPrice - (totalPrice * 0.05);

        System.out.printf("%.2f",finalPrice);
    }
}
