package NestedLoopsMoreExercises;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sumDigits = 0;
        int counter = 0;

        for (int i = 1; i <= firstNum; i++) {
            for (int j = 1; j <= secondNum; j++) {
                for (int k = 1; k <= thirdNum; k++) {


                    if (i % 2 == 0 && k % 2 == 0 && j >= 2 && j <= 7 &&
                        (j == 2 || j == 3 || j == 5 || j == 7)) {
                        System.out.println(i + " " + j + " "  + k);
                    }

                }
            }
        }


    }
}
