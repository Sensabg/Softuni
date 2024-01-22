package NestedLoopsLab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        while (!country.equals("End")) {
            double requiredMoney = Double.parseDouble(scanner.nextLine());

            double savedMoney = 0;
            while (requiredMoney > savedMoney) {
                double money = Double.parseDouble(scanner.nextLine());


                savedMoney += money;
            }
                System.out.printf("\nGoing to %s!", country);
            

            country = scanner.nextLine();
        }
    }
}
