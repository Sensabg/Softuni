package PBexamOne;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int windowsAmount = Integer.parseInt(scanner.nextLine());
        // "90X130" или "100X150" или "130X180" или "200X300";
        String windowsType = scanner.nextLine();
        String delivery = scanner.nextLine();

        double price = 0;

        if (windowsAmount < 10) {
            System.out.println("Invalid order");
        } else {
            switch (windowsType) {
                case "90X130":
                    price = 110* windowsAmount;
                    if (windowsAmount > 30 && windowsAmount < 60) {
                        price = price - (price * 0.05);
                    } else if (windowsAmount > 60) {
                        price = price - (price * 0.08);
                    }
                    break;
                case "100X150":
                    price = 140* windowsAmount;
                    if (windowsAmount > 40 && windowsAmount < 80) {
                        price = price - (price * 0.06);
                    } else if (windowsAmount > 80) {
                        price = price - (price * 0.10);
                    }
                    break;
                case"130X180":
                    price = 190 * windowsAmount;
                    if (windowsAmount > 20 && windowsAmount < 50) {
                        price = price - (price * 0.07);
                    } else if (windowsAmount > 50) {
                        price = price - (price * 0.12);
                    }
                    break;
                case "200X300":
                    price = 250 * windowsAmount;
                    if (windowsAmount > 25 && windowsAmount < 50) {
                        price = price - (price * 0.09);
                    } else if (windowsAmount > 50) {
                        price = price - (price * 0.14);
                    }
                    break;
            }
            if (delivery.equals("With delivery")) {
                price = price + 60;
            }

            if(windowsAmount > 99){
                price = price - ( price * 0.04);
            }
            System.out.printf("%.2f BGN",price);
        }
    }
}
