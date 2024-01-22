package NestedLoopsExercise;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int parsedInput = 0;
        int counter = 0;

        int sumReal = 0;
        int sumElse = 0;

        while (true) {
            if (!input.equals("stop")) {
                parsedInput = Integer.parseInt(input);
                if(parsedInput < 0){
                    System.out.println("Number is negative.");
                    parsedInput = 0;
                }
            } else {
                break;
            }
            for (int i = 1; i <= parsedInput; i++) {

                if (parsedInput % i == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                sumReal += parsedInput;
                counter = 0;
            } else {
                sumElse += parsedInput;
                counter = 0;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d",sumReal);
        System.out.printf("\nSum of all non prime numbers is: %d",sumElse);
    }
}
