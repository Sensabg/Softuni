package NestedLoopsMoreExercises;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magic = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        int i = 0;
        int j = 0;

        boolean isFound = false;

            for (i = start; i <= end; i++) {
                for (j = start; j <= end; j++) {
                    counter++;

                    if (i + j == magic) {
                        isFound = true;
                        break;
                    }
                }
                if(isFound){
                    break;
                }
            }

            if(isFound) {
                System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, magic);
            } else {
                System.out.printf("%d combinations - neither equals %d",counter,magic);
            }
    }
}
