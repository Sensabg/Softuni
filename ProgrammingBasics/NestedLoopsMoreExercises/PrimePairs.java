package NestedLoopsMoreExercises;

import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startValueOne = Integer.parseInt(scanner.nextLine());
        int startValueTwo = Integer.parseInt(scanner.nextLine());
        int endValueOne = Integer.parseInt(scanner.nextLine());
        int endValueTwo = Integer.parseInt(scanner.nextLine());

        int finalEndValueOne = startValueOne + endValueOne;
        int finalEndValueTwo = startValueTwo + endValueTwo;


        for (int i = startValueOne; i <= finalEndValueOne; i++) {
            for (int j = startValueTwo; j <= finalEndValueTwo; j++) {

                if((i % 2 != 0) && (j % 2 != 0) && (i % 3 != 0) && (j % 3 != 0)
                    && (i % 5 != 0) && (j % 5 != 0) && (i % 7 != 0) && (j % 7 != 0)) {

                    System.out.println(i + "" + j);

                }
            }
        }
    }
}

