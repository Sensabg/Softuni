package PBexamTwo;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bitcoinsAmount = Integer.parseInt(scanner.nextLine());
        double amountChineseYuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        int bitcoinPrice = bitcoinsAmount * 1168;
        double chineseYuanPrice = amountChineseYuan * 0.15;
        double chineseYuanConvert = chineseYuanPrice * 1.76;

        double price = chineseYuanConvert + bitcoinPrice;
        double priceConvert = price / 1.95;

        double totalCommission = priceConvert * (commission * 0.01);

        double totalPrice = priceConvert - totalCommission;

        System.out.printf("%.2f",totalPrice);
    }
}
