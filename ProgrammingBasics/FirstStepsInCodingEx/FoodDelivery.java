package FirstStepsInCodingEx;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double chickenMenu = 10.35;
        double fishMenu = 12.40;
        double vegetarianMenu = 8.15;
        double delivery = 2.50;

        int amountChickenMenus = Integer.parseInt(scanner.nextLine());
        int amountFishMenus = Integer.parseInt(scanner.nextLine());
        int amountVegetarianMenus = Integer.parseInt(scanner.nextLine());

        double totalChickens = amountChickenMenus * chickenMenu;
        double totalFishes = amountFishMenus * fishMenu;
        double totalVegetarian = Math.round(amountVegetarianMenus * vegetarianMenu * 100.0) / 100.0 ;

        double totalPrice = totalChickens + totalFishes + totalVegetarian;
        double desertPrice = totalPrice  * 0.20;

        double finalPrice = totalPrice + desertPrice + delivery;

        System.out.println(finalPrice);


    }
}
