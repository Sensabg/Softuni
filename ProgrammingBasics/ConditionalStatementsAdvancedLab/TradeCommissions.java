package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double s = Double.parseDouble(scanner.nextLine());

        double commission = -1;

        switch (city) {

            case "Sofia":

                if (s >= 0 && s <= 500) {
                    commission = s * 0.05;
                } else if (s > 500 && s <= 1000) {
                    commission = s * 0.07;
                } else if (s > 1000 && s <= 10000) {
                    commission = s * 0.08;
                } else if (s > 10000) {
                    commission = s * 0.12;
                }
                break;

            case "Varna":

                if (s >= 0 && s <= 500) {
                    commission = s * 0.045;
                } else if (s > 500 && s <= 1000) {
                    commission = s * 0.075;
                } else if (s > 1000 && s <= 10000) {
                    commission = s * 0.10;
                } else if (s > 10000) {
                    commission = s * 0.13;
                }
                break;

            case "Plovdiv":

                if (s >= 0 && s <= 500) {
                    commission = s * 0.055;
                } else if (s > 500 && s <= 1000) {
                    commission = s * 0.08;
                } else if (s > 1000 && s <= 10000) {
                    commission = s * 0.12;
                } else if (s > 10000) {
                    commission = s * 0.145;
                }
                break;
        }
        if (commission == -1) {
            System.out.println("error");
        } else {
            System.out.printf("%.2f", commission);
        }
    }
}
