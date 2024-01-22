package NestedLoopsLab;

import java.util.Scanner;

public class SumofTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rangeStart = Integer.parseInt(scanner.nextLine());
        int rangeEnd = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int counter = 0;

        int x1 = 0;
        int x2 = 0;

        boolean isFound = false;

        for (int i = rangeStart; i <= rangeEnd; i++) {
            for (int j = rangeStart; j <= rangeEnd; j++) {
                counter++;
                if (i + j == magicNumber) {
                    isFound = true;
                    x1 = i;
                    x2 = j;
                    break;
                }
            }
            if (isFound){
                break;
            }
        }
        if (isFound) {
            System.out.printf("Combination N:%d (%d + %d = %d)", counter, x1, x2, magicNumber);
        } else {
            System.out.printf("%d combinations - neither equals %d", counter, magicNumber);
        }
    }
}
