package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int amountChrysanthemums = Integer.parseInt(scanner.nextLine());
        int amountRoses = Integer.parseInt(scanner.nextLine());
        int amountTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holidayOrNot = scanner.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;

        int sumFlowers = amountChrysanthemums + amountTulips + amountRoses;

        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemumsPrice = 2.00 * amountChrysanthemums;
                rosesPrice = 4.10 * amountRoses;
                tulipsPrice = 2.50 * amountTulips;
                break;
            case "Autumn":
            case "Winter":
                chrysanthemumsPrice = 3.75 * amountChrysanthemums;
                rosesPrice = 4.50 * amountRoses;
                tulipsPrice = 4.15 * amountTulips;
                break;
        }

        double totalPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice ;

        if (holidayOrNot.equals("Y")) {
            totalPrice += totalPrice * 0.15;
        }

        if("Spring".equals(season) && amountTulips >= 7 ){
            totalPrice -= totalPrice * 0.05;
        }

        if("Winter".equals(season) && amountRoses >= 10 ){
            totalPrice -=totalPrice * 0.10;
        }

        if(sumFlowers >= 20) {
            totalPrice -= totalPrice * 0.20;
        }

        System.out.printf("%.2f",totalPrice + 2);
    }
}