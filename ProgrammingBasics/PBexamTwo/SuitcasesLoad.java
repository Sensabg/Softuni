package PBexamTwo;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Капацитетът на багажника – реално число в диапазона [100.0…6000.0]
        double luggageCarrier = Double.parseDouble(scanner.nextLine());

        double totalLuggage = 0;
        boolean noMoreSpace = false;
        int counter = 0;

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            counter++;
            double luggage = Double.parseDouble(command);

            if (counter % 3 == 0){
                luggage = luggage + ( luggage * 0.10);
            }

                totalLuggage += luggage;

            if (luggageCarrier < totalLuggage) {
                counter--;
                noMoreSpace = true;
                break;
            }

            command = scanner.nextLine();
        }

        if(!noMoreSpace){
            System.out.println("Congratulations! All suitcases are loaded!");
        } else {
            System.out.println("No more space!");
        }
        System.out.printf("Statistic: %d suitcases loaded.",counter);
    }
}
