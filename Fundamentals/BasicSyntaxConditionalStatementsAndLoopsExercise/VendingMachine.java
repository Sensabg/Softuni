package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalMoney = 0;

        String command = scanner.nextLine();
        while (true) {
            if (!command.equals("Start")) {
                double coins = Double.parseDouble(command);
                if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1.0 && coins != 2.0) {
                    System.out.printf("Cannot accept %.2f\n", coins);
                } else {
                    totalMoney += coins;
                }
            } else {
                command = scanner.nextLine();
                while(!"End".equals(command)) {
                    String drinks = command;
                    switch (drinks) {
                        case "Nuts":
                            if (totalMoney >= 2.0) {
                                System.out.println("Purchased Nuts");
                                totalMoney -= 2;
                            } else {
                                System.out.println("Sorry, not enough money");
                            }
                            break;
                        case "Water":
                            if (totalMoney >= 0.7) {
                                System.out.println("Purchased Water");
                                totalMoney -= 0.7;
                            } else {
                                System.out.println("Sorry, not enough money");
                            }
                            break;
                        case "Crisps":
                            if (totalMoney >= 1.5) {
                                System.out.println("Purchased Crisps");
                                totalMoney -= 1.5;
                            } else {
                                System.out.println("Sorry, not enough money");
                            }
                            break;
                        case "Soda":
                            if (totalMoney >= 0.8) {
                                System.out.println("Purchased Soda");
                                totalMoney -= 0.8;
                            } else {
                                System.out.println("Sorry, not enough money");
                            }
                            break;
                        case "Coke":
                            if (totalMoney >= 1.0) {
                                totalMoney -= 1;
                                System.out.println("Purchased Coke");
                            } else {
                                System.out.println("Sorry, not enough money");
                            }
                            break;
                        default:
                            System.out.println("Invalid product");
                            break;

                    }
                    command = scanner.nextLine();
                }
            }
            if(command.equals("End")){
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Change: %.2f",totalMoney);
    }
}