package ForLoopMoreExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        int counter = 0;
        int oddSum = 0;
        int evenSum =0;

        for (int i = 0; i < n; i++) {

            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());

            sum = a + b;

            if (i % 2 == 0) {
                evenSum = sum;
            } else {
                oddSum = sum;
            }

            if ( n == 1 && a == b ){
                oddSum = evenSum;
            }
        }

        if (evenSum == oddSum) {
            System.out.printf("Yes, value=%d", oddSum);
        } else {
            System.out.printf("No, maxdiff=%d", Math.abs(oddSum - evenSum));
        }
    }
}