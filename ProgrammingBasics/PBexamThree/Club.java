package PBexamThree;

import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double desiredPrice = Double.parseDouble(scanner.nextLine());

        double totalPrice = 0;
        double totalCocktailPrice = 0;

        boolean goalReached = false;

        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String cocktail = command;
            int amountCocktail = Integer.parseInt(scanner.nextLine());
            int cocktailPrice = cocktail.length();

            totalCocktailPrice += cocktailPrice * amountCocktail;

            if (totalCocktailPrice % 2 != 0) {
                totalCocktailPrice = totalCocktailPrice - (totalCocktailPrice * 0.25);
            }

            totalPrice += totalCocktailPrice;

            if (totalPrice >= desiredPrice) {
                goalReached = true;
                break;
            }

            totalCocktailPrice = 0;

            command = scanner.nextLine();
        }

        if (!goalReached) {
            System.out.printf("We need %.2f leva more.\n", desiredPrice - totalPrice);
        } else {
            System.out.println("Target acquired.");
        }
        System.out.printf("Club income - %.2f leva.\n", totalPrice);
    }
}
