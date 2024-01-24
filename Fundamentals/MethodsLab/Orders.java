package MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double coffeePrice = 1.50;
        double waterPrice = 1.00;
        double cokePrice = 1.40;
        double snacksPrice = 2.00;

        switch (drink){
            case"coffee":
                calculatePrice(coffeePrice,quantity);
                break;
            case"water":
                calculatePrice(waterPrice,quantity);
                break;
            case"coke":
                calculatePrice(cokePrice,quantity);
                break;
            case"snacks":
                calculatePrice(snacksPrice,quantity);
                break;
        }
    }
    public static void calculatePrice(double price, int quantity) {

        System.out.printf("%.2f", price * quantity);
    }
}
