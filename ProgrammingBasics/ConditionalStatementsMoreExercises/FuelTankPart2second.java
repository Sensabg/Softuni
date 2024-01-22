package ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class FuelTankPart2second {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String Fuel = scanner.nextLine();
        int amountFuel = Integer.parseInt(scanner.nextLine());
        String Card = scanner.nextLine();

        double price = 0;

       switch (Fuel) {
           case "Gas":
               price = 0.93;
               switch (Card) {
                   case "Yes":
                       price = 0.93 - 0.08;
                       break;
               }
               break;
           case "Gasoline":
               price = 2.22;
               switch (Card) {
                   case "Yes":
                       price = 2.22 - 0.18;
                       break;
               }
               break;
           case "Diesel":
               price = 2.33;
               switch (Card) {
                   case "Yes":
                       price = 2.33 - 0.12;
                       break;
               }
                       break;
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
