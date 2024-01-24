package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountGroup = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;
        double totalPrice = 0;

        switch (day) {
            case "Friday":
                switch (groupType) {
                    case"Students":
                        price = 8.45;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 30){
                            totalPrice = (amountGroup * price) - ((amountGroup * price) * 0.15);
                        }
                        break;
                    case"Business":
                        price = 10.90;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 100){
                            totalPrice = ((amountGroup - 10) * price);
                        }
                        break;
                    case"Regular":
                        price = 15;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 10 && amountGroup <= 20){
                            totalPrice = (amountGroup * price) - ((amountGroup * price) * 0.05);
                        }
                        break;
                }
                break;
            case "Saturday":
                switch (groupType) {
                    case"Students":
                        price = 9.80;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 30){
                            totalPrice = (amountGroup * price) - ((amountGroup * price) * 0.15);
                        }
                        break;
                    case"Business":
                        price = 15.60;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 100){
                            totalPrice = ((amountGroup - 10) * price);
                        }
                        break;
                    case"Regular":
                        price = 20;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 10 && amountGroup <= 20){
                            totalPrice = (amountGroup * price) - ((amountGroup * price) * 0.05);
                        }
                        break;
                }
                break;
            case "Sunday":
                switch (groupType) {
                    case"Students":
                        price = 10.46;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 30){
                            totalPrice = (amountGroup * price) - ((amountGroup * price) * 0.15);
                        }
                        break;
                    case"Business":
                        price = 16;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 100){
                            totalPrice = ((amountGroup - 10) * price);
                        }
                        break;
                    case"Regular":
                        price = 22.50;
                        totalPrice = (amountGroup * price);
                        if(amountGroup >= 10 && amountGroup <= 20){
                            totalPrice = (amountGroup * price) - ((amountGroup * price) * 0.05);
                        }
                        break;
                }
                break;
        }
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
