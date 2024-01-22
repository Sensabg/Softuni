package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        double price = 0.0;
        switch (season) {
            case "summer":

                if (budget <= 100) {
                    destination = "Bulgaria";
                    price = budget - ( budget * 0.3);
                } else if ( budget <= 1000){
                    destination = "Balkans";
                    price = budget - ( budget * 0.4);
                } else if (budget > 1000 ) {
                    destination = "Europe";
                    price = budget - ( budget * 0.9);
                }

                break;
            case "winter":

                if (budget <= 100) {
                    destination = "Bulgaria";
                    price = budget - ( budget * 0.7);
                }  else if ( budget <= 1000){
                    destination = "Balkans";
                    price = budget - ( budget * 0.8);
                } else if (budget > 1000 ) {
                    destination = "Europe";
                    price = budget - ( budget * 0.9);
                }

                break;
        }
        String place = "";
        if ("Europe".equals(destination) || "winter".equals(season)){
            place = "Hotel";
        } else {
            place = "Camp";
        }

        double diff = Math.abs(budget - price );

        System.out.printf("Somewhere in %s",destination);
        System.out.printf("\n%s - %.2f ", place, diff);
    }
}
