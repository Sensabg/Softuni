package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int price = 0;
        boolean error = false;

        switch (typeDay) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    price = 12;
                } else if (age > 18 && age <= 64) {
                    price = 18;
                } else if (age <= 122 && age > 64) {
                    price = 12;
                } else {
                    error = true;
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    price = 15;
                } else if (age > 18 && age <= 64) {
                    price = 20;
                } else if (age <= 122 && age > 64) {
                    price = 15;
                } else {
                    error = true;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                } else if (age > 18 && age <= 64) {
                    price = 12;
                } else if (age <= 122 && age > 64) {
                    price = 10;
                } else {
                    error = true;
                }
                break;
        }
        if (!error) {
            System.out.printf("%d$", price);
        } else {
            System.out.println("Error!");
        }
    }
}
