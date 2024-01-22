package ForLoopExercise;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washerPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int odd = 0;
        int even = 0;
        int savedMoney = 0;
        int birthdayMoney = 0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                even++;
                savedMoney += 10;
                birthdayMoney = savedMoney + birthdayMoney;
            } else {
                odd++;
            }
        }

        savedMoney = birthdayMoney - even;
        toyPrice = toyPrice * odd;
        int totalSavedMoney = savedMoney + toyPrice;
        double priceDiff = Math.abs(totalSavedMoney - washerPrice);

        if (totalSavedMoney >= washerPrice) {
            System.out.printf("Yes! %.2f", priceDiff);
        } else {
            System.out.printf("No! %.2f", priceDiff);
        }

    }
}
