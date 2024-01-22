package ForLoopMoreExercises;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double startingMoney = Double.parseDouble(scanner.nextLine());
        int years = Integer.parseInt(scanner.nextLine());

        int yearsLive = Math.abs(1800 - years);

        int yearsCount = 17;
        int money = 12000;
        int totalMoneySpent = 0;

        for (int i = 0; i <= yearsLive; i++) {
            yearsCount++;

            if (i % 2 == 0) {
                totalMoneySpent += money;
            } else {
                totalMoneySpent += (money + yearsCount * 50);
            }
        }

        double priceDiff = Math.abs(startingMoney - totalMoneySpent);

        if (totalMoneySpent <= startingMoney) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", priceDiff);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", priceDiff);
        }
    }
}
