package FirsStepsInCoding;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double grass = Double.parseDouble(scanner.nextLine());

        double priceFor1 = 7.61;

        double Price = priceFor1 * grass;
        double discount = Price * 0.18;

        double EndPrice = Math.abs(discount - Price);

        System.out.printf("The final price is: %.2f lv.",EndPrice);
        System.out.printf("\nThe discount is: %.2f lv.", discount);
    }
}
