package ForLoopLab;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < n; i++) {
            int digits = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0) {
                sumEven = sumEven + digits;
            } else {
                sumOdd = sumOdd + digits;
            }
        }
        if (sumOdd == sumEven) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sumEven);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(sumEven - sumOdd));
        }
    }
}
