package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double balance = currentBalance;

        double spentMoney = 0;

        String command = scanner.nextLine();
        while (true) {
            String game = command;

            if (currentBalance <= 0) {
                System.out.println("Out of money!");
                break;
            }

            if ("Game Time".equals(game)) {
                break;
            }

            switch (game) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (currentBalance < 39.99) {
                        System.out.println("Too Expensive");
                    } else {
                        currentBalance -= 39.99;
                        spentMoney += 39.99;
                        if (game.equals("RoverWatch Origins Edition")) {
                            System.out.println("Bought RoverWatch Origins Edition");
                        } else {
                            System.out.println("Bought OutFall 4");
                        }
                    }
                    break;
                case "CS: OG":
                    if (currentBalance < 15.99) {
                        System.out.println("Too Expensive");
                    } else {
                        currentBalance -= 15.99;
                        spentMoney += 15.99;
                        System.out.println("Bought CS: OG");
                    }
                    break;
                case "Zplinter Zell":
                    if (currentBalance < 19.99) {
                        System.out.println("Too Expensive");
                    } else {
                        currentBalance -= 19.99;
                        spentMoney += 19.99;
                        System.out.println("Bought Zplinter Zell");
                    }
                    break;
                case "Honored 2":
                    if (currentBalance < 59.99) {
                        System.out.println("Too Expensive");
                    } else {
                        currentBalance -= 59.99;
                        spentMoney += 59.99;
                        System.out.println("Bought Honored 2");
                    }
                    break;
                case "RoverWatch":
                    if (currentBalance < 29.99) {
                        System.out.println("Too Expensive");
                    } else {
                        currentBalance -= 29.99;
                        spentMoney += 29.99;
                        System.out.println("Bought RoverWatch");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            command = scanner.nextLine();
        }
        if ( 0 < currentBalance) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, balance - spentMoney);
        }
    }
}
