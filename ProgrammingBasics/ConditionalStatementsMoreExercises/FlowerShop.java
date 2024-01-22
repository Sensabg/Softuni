package ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountM = Integer.parseInt(scanner.nextLine());
        int amountZ = Integer.parseInt(scanner.nextLine());
        int amountR = Integer.parseInt(scanner.nextLine());
        int amountC = Integer.parseInt(scanner.nextLine());
        double priceGift = Double.parseDouble(scanner.nextLine());

        double priceM = 3.25;
        double priceZ = 4;
        double priceR = 3.50;
        double priceC = 8;

        double totalPriceM = amountM * priceM;
        double totalPriceZ = amountZ * priceZ;
        double totalPriceR = amountR * priceR;
        double totalPriceC = amountC * priceC;

        double totalPrice = totalPriceM + totalPriceZ + totalPriceR + totalPriceC;
        double tax = totalPrice * 0.05;
        double income = totalPrice - tax;

        double profit = Math.abs(priceGift - income);

        if ( priceGift > income) {
            System.out.printf("She will have to borrow %.0f leva.",Math.ceil(profit));
        } else {
            System.out.printf("She is left with %.0f leva.",Math.floor(profit));
        }
    }
}
