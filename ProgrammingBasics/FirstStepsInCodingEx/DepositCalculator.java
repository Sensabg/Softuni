package FirstStepsInCodingEx;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double depositPrice = Double.parseDouble(scanner.nextLine());
        int depositPeriod = Integer.parseInt(scanner.nextLine());
        double yearDevidend = Double.parseDouble(scanner.nextLine());

        double devidend = depositPrice * (yearDevidend / 100.0);
        double monthlyDevidend = devidend / 12;
        double totalPrice = depositPrice + depositPeriod * monthlyDevidend;

        System.out.println(totalPrice);



    }
}
