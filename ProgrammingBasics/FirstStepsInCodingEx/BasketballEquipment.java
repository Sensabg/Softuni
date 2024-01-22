package FirstStepsInCodingEx;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int yearTax = Integer.parseInt(scanner.nextLine());

        double shoesPrice = yearTax - ( yearTax * 0.40);
        double clothesPrice = shoesPrice - ( shoesPrice * 0.20);
        double ballPrice = clothesPrice * 0.25;
        double accessories = ballPrice * 0.20;

        double totalPrice = yearTax + shoesPrice + clothesPrice + ballPrice + accessories;

        System.out.println(totalPrice);
    }
}
