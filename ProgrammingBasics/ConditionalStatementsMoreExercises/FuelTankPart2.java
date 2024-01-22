package ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String Fuel = scanner.nextLine();
        int amountFuel = Integer.parseInt(scanner.nextLine());
        String Card = scanner.nextLine();

        double price = 0;

        if ("Gasoline".equals(Fuel)){
           price = 2.22;
        } else if ("Gas".equals(Fuel)){
            price = 0.93;
        } else if ("Diesel".equals(Fuel)) {
            price = 2.33;
        }

        if ("Yes".equals(Card)) {
            if ("Gasoline".equals(Fuel)) {
                price = 2.22 - 0.18;
            } else if ("Gas".equals(Fuel)) {
                price = 0.93 - 0.08;
            } else if ("Diesel".equals(Fuel)){
                price = 2.33 - 0.12;
            }
        }

        double totalPrice = price * amountFuel;

        if (amountFuel >= 20 && amountFuel <= 25) {
            totalPrice = totalPrice - ( totalPrice * 0.08 );
        } else if (amountFuel > 25) {
            totalPrice = totalPrice - (totalPrice * 0.10);
        }

        System.out.printf("%.2f lv.", totalPrice);
    }
}
