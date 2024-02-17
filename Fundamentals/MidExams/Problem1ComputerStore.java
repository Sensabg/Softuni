package MidExams;

import java.util.Scanner;

public class Problem1ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double sum = 0;
        double tax;
        double totalSum;
        String command = scanner.nextLine();
        while (true) {

            if (command.equals("special")) {
                tax = sum * 0.20;
                totalSum =(sum + tax) - ((sum + tax) * 0.10);
                break;
            }
            if (command.equals("regular")) {
                tax = sum * 0.20;
                totalSum = sum + tax;
                break;
            }

            double expenses = Double.parseDouble(command);
            if (expenses <= 0) {
                System.out.println("Invalid price!");
            } else {
                sum += expenses;
            }
            command = scanner.nextLine();
        }
        if(totalSum == 0){
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", sum);
            System.out.printf("Taxes: %.2f$\n", tax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$\n", totalSum);
        }
    }
}