package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String group = scanner.nextLine();
        int studentsAmount = Integer.parseInt(scanner.nextLine());
        int sleepover = Integer.parseInt(scanner.nextLine());

        double priceBoys = 0;
        double priceGirls = 0;
        double priceMixed = 0;
        String sport = "";

        switch (season) {
            case "Winter":
                priceBoys = 9.60;
                priceGirls = 9.60;
                priceMixed = 10;
                switch (group) {
                    case "girls":
                        sport = "Gymnastics";
                        break;
                    case "boys":
                        sport = "Judo";
                        break;
                    case "mixed":
                        sport = "Ski";
                        break;
                }
                break;
            case "Spring":
                priceBoys = 7.20;
                priceGirls = 7.20;
                priceMixed = 9.50;
                switch (group) {
                    case "girls":
                        sport = "Athletics";
                        break;
                    case "boys":
                        sport = "Tennis";
                        break;
                    case "mixed":
                        sport = "Cycling";
                        break;
                }
                break;
            case "Summer":
                priceBoys = 15;
                priceGirls = 15;
                priceMixed = 20;
                switch (group) {
                    case "girls":
                        sport = "Volleyball";
                        break;
                    case "boys":
                        sport = "Football";
                        break;
                    case "mixed":
                        sport = "Swimming";
                        break;
                }
                break;
        }
        double totalPriceBoys = sleepover * studentsAmount * priceBoys;
        double totalPriceGirls = sleepover * studentsAmount * priceGirls;
        double totalPriceMixed = sleepover * studentsAmount * priceMixed;

        if (studentsAmount >= 50) {
            totalPriceMixed = totalPriceMixed - (totalPriceMixed * 0.50);
            totalPriceBoys = totalPriceBoys - (totalPriceBoys * 0.50);
            totalPriceGirls = totalPriceGirls - (totalPriceGirls * 0.50);
        } else if (studentsAmount >= 20) {
            totalPriceMixed = totalPriceMixed - (totalPriceMixed * 0.15);
            totalPriceBoys = totalPriceBoys - (totalPriceBoys * 0.15);
            totalPriceGirls = totalPriceGirls - (totalPriceGirls * 0.15);
        } else if (studentsAmount >= 10) {
            totalPriceMixed = totalPriceMixed - (totalPriceMixed * 0.05);
            totalPriceBoys = totalPriceBoys - (totalPriceBoys * 0.05);
            totalPriceGirls = totalPriceGirls - (totalPriceGirls * 0.05);
        }

        if (group.equals("mixed")) {
            System.out.printf("%s %.2f lv.", sport, totalPriceMixed);
        } else if (group.equals("boys")) {
            System.out.printf("%s %.2f lv.", sport, totalPriceBoys);
        } else if (group.equals("girls")) {
            System.out.printf("%s %.2f lv.", sport, totalPriceGirls);
        }
    }
}