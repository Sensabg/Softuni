package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermans = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        switch (season) {
            case "Spring":
                price = 3000;

                break;
            case "Summer":
            case "Autumn":
                price = 4200;

                break;
            case "Winter":
                price = 2600;

                break;
        }

        if(fishermans <= 6){
            price = price - (price * 0.10);
        }  else if (fishermans > 7 && fishermans <=11 ){
            price = price - (price * 0.15);
        } else if (fishermans > 12) {
            price = price - (price * 0.25);
        }
        if(fishermans % 2 == 0 && !season.equals("Autumn")){
            price = price - (price * 0.05);
        }

        double diff = Math.abs(price - budget);

        if(price <= budget){
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.",diff);
        }

    }
}
