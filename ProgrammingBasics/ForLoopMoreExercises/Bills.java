package ForLoopMoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int monthsAmount = Integer.parseInt(scanner.nextLine());

        double waterPrice = 20;
        double waterTotalPrice = 0;

        double internetPrice = 15;
        double internetTotalPrice = 0;

        double elsePrice = 0;
        double electricityTotalPrice = 0;

        double combinedPrice = 0;
        double totalPrice = 0;

        for (int i = 0; i < monthsAmount; i++) {
            double electricityPerMonthPrice = Double.parseDouble(scanner.nextLine());

            electricityTotalPrice += electricityPerMonthPrice;
            waterTotalPrice += waterPrice;
            internetTotalPrice += internetPrice;

            combinedPrice = electricityPerMonthPrice + waterPrice + internetPrice;
            elsePrice += (combinedPrice) + (combinedPrice * 0.20);
        }

        totalPrice = electricityTotalPrice + waterTotalPrice + internetTotalPrice + elsePrice;
        totalPrice = totalPrice / monthsAmount;

        System.out.printf("Electricity: %.2f lv", electricityTotalPrice);
        System.out.printf("\nWater: %.2f lv", waterTotalPrice);
        System.out.printf("\nInternet: %.2f lv", internetTotalPrice);
        System.out.printf("\nOther: %.2f lv", elsePrice);
        System.out.printf("\nAverage: %.2f lv", totalPrice);
    }
}
