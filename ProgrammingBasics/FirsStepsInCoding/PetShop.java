package FirsStepsInCoding;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double dogPackage = 2.50;
        double catPackage = 4.0;

        int amountDogPackages = Integer.parseInt(scanner.nextLine());
        int amountCatPackages = Integer.parseInt(scanner.nextLine());

        double dogEndPrice = amountDogPackages * dogPackage;
        double catEndPrice = amountCatPackages * catPackage;

        double EndPrice = catEndPrice + dogEndPrice;

        System.out.printf("%.1f lv.", EndPrice);
    }
}
