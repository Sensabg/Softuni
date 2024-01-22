package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double carPrice = 0;
        String carClass = "";
        String car = "";
        switch (season) {

            case "Summer":
                car = "Cabrio";
                if (budget <= 100) {
                    carClass = "Economy class";
                    carPrice = budget * 0.35;
                } else if (budget <= 500) {
                    carClass = "Compact class";
                    carPrice = budget * 0.45;
                }
                break;

            case "Winter":
                car = "Jeep";
                if (budget <= 100) {
                    carClass = "Economy class";
                    carPrice = budget * 0.65;
                } else if (budget <= 500) {
                    carClass = "Compact class";
                    carPrice = budget * 0.80;
                }
                break;
        }
        if (budget > 500) {
            carPrice = budget * 0.90;
            car = "Jeep";
            carClass = "Luxury class";
        }
        System.out.printf("%s",carClass);
        System.out.printf("\n%s - %.2f ", car , carPrice);
    }
}
