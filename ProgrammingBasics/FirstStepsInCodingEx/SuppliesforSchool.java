package FirstStepsInCodingEx;

import java.util.Scanner;

public class SuppliesforSchool {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double packagePen = 5.80;
        double packageMarker = 7.20;
        double chemistry = 1.20;

        int amountPens = Integer.parseInt(scanner.nextLine());
        int amountMarkers = Integer.parseInt(scanner.nextLine());
        int amountChemistry = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double pricePen = amountPens * packagePen;
        double priceMarkers = amountMarkers * packageMarker;
        double priceChemistry = amountChemistry * chemistry;

        double totalPrice = pricePen + priceMarkers + priceChemistry;
        double totalPriceWithDiscount = totalPrice - (totalPrice * ( discount / 100.0) );

        System.out.println(totalPriceWithDiscount);
    }
}
